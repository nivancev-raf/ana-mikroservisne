package anamikroservisi.korisnicki_servis.mapper;


import anamikroservisi.korisnicki_servis.dto.UserCreateDto;
import anamikroservisi.korisnicki_servis.dto.UserDto;
import anamikroservisi.korisnicki_servis.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public AppUser userCreateDtoToUser(UserCreateDto userCreateDto) {
        AppUser appUser = new AppUser();
//        appUser.setId(userCreateDto.getId());
        appUser.setUsername(userCreateDto.getUsername());
        appUser.setEmail(userCreateDto.getEmail());
        appUser.setPassword(userCreateDto.getPassword());
        return appUser;
    }

    public UserDto userToUserDto(AppUser appUser) {
        UserDto userDto = new UserDto();
        userDto.setUsername(appUser.getUsername());
        userDto.setEmail(appUser.getEmail());
        return userDto;
    }

}
