package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.TokenRequestDto;
import anamikroservisi.raspored_servis.dto.TokenResponseDto;
import anamikroservisi.raspored_servis.dto.UserCreateDto;
import anamikroservisi.raspored_servis.dto.UserDto;

public interface UserSerivce {


    UserDto add(UserCreateDto clientCreateDto);

    UserCreateDto update (Long id, UserCreateDto clientUpdateDto);
    void delete(Long id);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    void assignRole(Long userId, Long roleId);

//    ClientDto update (ClientUpdateDto clientUpdateDto);
//
//    TokenResponseDto login(TokenRequestDto tokenRequestDto);
//
//    ClaimResponseDto getClaim(TokenResponseDto tokenResponseDto);
//
//    List<Client> getAllClients();
//
//    ClientAdminDto updateClientActivation(ClientAdminDto clientAdminDto);
//
//    ClientAdminDto updateClientById(Long id, ClientAdminDto clientAdminDto);
}
