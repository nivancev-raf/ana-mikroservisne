package anamikroservisi.korisnicki_servis.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserCreateDto {
    private String username;
    private String email;
    private String password;
}
