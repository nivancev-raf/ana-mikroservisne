package anamikroservisi.korisnicki_servis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private List<String> uloge;

//    private String password; -> ne treba nam password u DTO-u

}
