package anamikroservisi.raspored_servis.controller;

import anamikroservisi.raspored_servis.dto.*;
import anamikroservisi.raspored_servis.service.RoleService;
import anamikroservisi.raspored_servis.service.UserSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private RoleService roleService;
    private UserSerivce userService;

    public AuthController(RoleService roleService, UserSerivce userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    // register user
    @PostMapping("/registerUser")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserCreateDto userCreateDTO) {
        // Logika za slanje zahteva ka notifikacionom servisu preko message brokera
        return new ResponseEntity<>(userService.add(userCreateDTO), HttpStatus.CREATED);
    }

    // update user info
//    @CheckSecurity(roles = {"admin"})
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserCreateDto> updateUser(@PathVariable Long id, @RequestBody UserCreateDto userCreateDTO){
        return new ResponseEntity<>(userService.update(id, userCreateDTO), HttpStatus.OK);
    }

    // delete user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    // create role
    @PostMapping("/createRole")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleCreateDto roleCreateDTO) {
        return new ResponseEntity<>(roleService.add(roleCreateDTO), HttpStatus.CREATED);
    }

    // delete role
    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




    // PREDLOZENE API OPERACIJE

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    // dodela role korisniku
    @PostMapping("/dodela-uloge")
    public ResponseEntity<?> assignRoleToUser(@RequestBody RoleAssignDto roleAssignDto) {
        userService.assignRole(roleAssignDto.getUserId(), roleAssignDto.getRoleId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Dodatne metode, ako su potrebne
}