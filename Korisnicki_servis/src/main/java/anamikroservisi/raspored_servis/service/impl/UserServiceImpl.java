package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.*;
import anamikroservisi.raspored_servis.exception.NotFoundException;
import anamikroservisi.raspored_servis.model.AppUser;
import anamikroservisi.raspored_servis.model.Role;
import anamikroservisi.raspored_servis.repository.RoleRepository;
import anamikroservisi.raspored_servis.repository.UserRepository;
import anamikroservisi.raspored_servis.mapper.UserMapper;
import anamikroservisi.raspored_servis.service.TokenService;
import anamikroservisi.raspored_servis.service.UserSerivce;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserSerivce {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private TokenService tokenService;
    private RoleRepository roleRepository;

    private RestTemplate restTemplate;
    private RestTemplateServiceImpl restTemplateServiceImpl;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        AppUser appUser = userMapper.userCreateDtoToUser(userCreateDto);
        userRepository.save(appUser);
        UserDto userDto = userMapper.userToUserDto(appUser);
        return userDto;
    }

    @Override
    public UserCreateDto update(Long id, UserCreateDto userUpdateDto) {
        AppUser appUser = userRepository.findById(id).orElse(null);
        appUser.setUsername(userUpdateDto.getUsername());
        appUser.setPassword(userUpdateDto.getPassword());
        appUser.setEmail(userUpdateDto.getEmail());
        appUser.setId(id);
        userRepository.save(appUser);
        return userUpdateDto;
    }

    @Override
    public void delete(Long id) {
        AppUser appUser = userRepository.findById(id).orElse(null);
        userRepository.delete(appUser);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        Claims claims = Jwts.claims();
        if (userRepository.findByUsername(tokenRequestDto.getUsername()).isPresent()) {
            AppUser appUser = userRepository.findByUsername(tokenRequestDto.getUsername()).get();
            claims.put("id", appUser.getId());
            List<String> roleNames = appUser.getRoles().stream()
                    .map(Role::getRoleName)
                    .collect(Collectors.toList());
            claims.put("roles", roleNames);
        }else {
            throw new NotFoundException(String.format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                    tokenRequestDto.getPassword()));
        }
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public void assignRole(Long userId, Long roleId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + roleId));

        appUser.getRoles().add(role);


//        Prilikom registracije novog korisnika koji ima ulogu nastavnika, potrebno je dodati (uneti) ga i
//        u mikroservisu za upravljanje rasporedom. Ovo je potrebno obezbediti pomoću sinhrone
//        komunikacije između servisa.

        if (role.getRoleName().equalsIgnoreCase("nastavnik")) {
            restTemplateServiceImpl = new RestTemplateServiceImpl();
            restTemplate = restTemplateServiceImpl.setupRestTemplate(restTemplate);

            // podaci su hardCode posto ne mogu iz appUser da se izvuku jer ne postoje ta polja u klasi AppUser
            NastavnikDto nastavnikDto = new NastavnikDto();
            nastavnikDto.setIme("imeNastavnika");
            nastavnikDto.setPrezime("prezimeNastavnika");
            nastavnikDto.setZvanje("zvanjeNastavnika");
            nastavnikDto.setEmail("emailNastavnika@gmail.com");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            RequestEntity<NastavnikDto> requestEntity = RequestEntity.post(URI.create("http://localhost:8084/raspored-servis/api/raspored/nastavnik")).headers(headers).body(nastavnikDto);

            ResponseEntity<NastavnikDto> responseEntity = restTemplate.exchange(requestEntity, NastavnikDto.class);
            System.out.println(responseEntity.getBody());
        }


        userRepository.save(appUser);

    }


}
