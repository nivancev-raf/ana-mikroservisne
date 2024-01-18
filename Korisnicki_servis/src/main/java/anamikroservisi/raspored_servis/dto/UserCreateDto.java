package anamikroservisi.raspored_servis.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateDto {
    private String username;
    private String email;
    private String password;
}
