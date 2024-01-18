package anamikroservisi.raspored_servis.mapper;


import anamikroservisi.raspored_servis.dto.UserCreateDto;
import anamikroservisi.raspored_servis.dto.UserDto;
import anamikroservisi.raspored_servis.model.AppUser;
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
