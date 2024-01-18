package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.RoleCreateDto;
import anamikroservisi.raspored_servis.dto.RoleDto;
import anamikroservisi.raspored_servis.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    // roleCreateDtoToRole
    public Role roleCreateDtoToRole(RoleCreateDto roleCreateDto) {
        Role role = new Role();
        role.setRoleName(roleCreateDto.getRoleName());
        role.setRoleDescription(roleCreateDto.getRoleDescription());
        return role;
    }
    // roleToRoleDto
    public RoleDto roleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName(role.getRoleName());
        roleDto.setRoleDescription(role.getRoleDescription());
        return roleDto;
    }
}
