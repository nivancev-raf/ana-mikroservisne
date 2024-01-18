package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.RoleCreateDto;
import anamikroservisi.raspored_servis.dto.RoleDto;

public interface RoleService {

    RoleDto add(RoleCreateDto roleCreateDto);

    void delete(Long id);
}
