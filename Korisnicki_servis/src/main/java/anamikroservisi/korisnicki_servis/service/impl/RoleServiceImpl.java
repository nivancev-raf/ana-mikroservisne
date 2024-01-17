package anamikroservisi.korisnicki_servis.service.impl;

import anamikroservisi.korisnicki_servis.dto.RoleCreateDto;
import anamikroservisi.korisnicki_servis.dto.RoleDto;
import anamikroservisi.korisnicki_servis.mapper.RoleMapper;
import anamikroservisi.korisnicki_servis.model.Role;
import anamikroservisi.korisnicki_servis.repository.RoleRepository;
import anamikroservisi.korisnicki_servis.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto add(RoleCreateDto roleCreateDto) {
        Role role = roleMapper.roleCreateDtoToRole(roleCreateDto);
        roleRepository.save(role);
        RoleDto roleDto = roleMapper.roleToRoleDto(role);
        return roleDto;
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        roleRepository.delete(role);
    }
}
