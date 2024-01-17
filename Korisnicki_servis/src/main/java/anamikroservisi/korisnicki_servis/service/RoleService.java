package anamikroservisi.korisnicki_servis.service;

import anamikroservisi.korisnicki_servis.dto.RoleCreateDto;
import anamikroservisi.korisnicki_servis.dto.RoleDto;
import anamikroservisi.korisnicki_servis.dto.UserCreateDto;
import anamikroservisi.korisnicki_servis.dto.UserDto;

public interface RoleService {

    RoleDto add(RoleCreateDto roleCreateDto);

    void delete(Long id);
}
