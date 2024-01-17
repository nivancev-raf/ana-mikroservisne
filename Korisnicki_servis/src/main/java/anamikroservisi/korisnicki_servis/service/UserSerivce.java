package anamikroservisi.korisnicki_servis.service;

import anamikroservisi.korisnicki_servis.dto.*;

import java.util.List;

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
