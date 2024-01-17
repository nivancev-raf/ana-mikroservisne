package anamikroservisi.korisnicki_servis.service.impl;

import anamikroservisi.korisnicki_servis.dto.TokenRequestDto;
import anamikroservisi.korisnicki_servis.dto.TokenResponseDto;
import anamikroservisi.korisnicki_servis.dto.UserCreateDto;
import anamikroservisi.korisnicki_servis.dto.UserDto;
import anamikroservisi.korisnicki_servis.exception.NotFoundException;
import anamikroservisi.korisnicki_servis.mapper.UserMapper;
import anamikroservisi.korisnicki_servis.model.Role;
import anamikroservisi.korisnicki_servis.model.AppUser;
import anamikroservisi.korisnicki_servis.repository.RoleRepository;
import anamikroservisi.korisnicki_servis.repository.UserRepository;
import anamikroservisi.korisnicki_servis.service.TokenService;
import anamikroservisi.korisnicki_servis.service.UserSerivce;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserSerivce {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private TokenService tokenService;
    private RoleRepository roleRepository;


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
        userRepository.save(appUser);

    }


}
