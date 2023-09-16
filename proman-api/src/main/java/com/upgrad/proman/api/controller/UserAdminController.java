package com.upgrad.proman.api.controller;


import com.upgrad.proman.api.model.PermissionsType;
import com.upgrad.proman.api.model.RoleDetailsType;
import com.upgrad.proman.api.model.UserDetailsResponse;
import com.upgrad.proman.api.model.UserStatusType;
import com.upgrad.proman.service.business.UserAdminBusinessService;
import com.upgrad.proman.service.entity.RoleEntity;
import com.upgrad.proman.service.entity.UserEntity;
import com.upgrad.proman.service.exception.ResourceNotFoundException;
import com.upgrad.proman.service.type.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserAdminController {
    @Autowired
    private UserAdminBusinessService businessService;


    @GetMapping("/users/{id}")
    public ResponseEntity<UserDetailsResponse> getUser(@PathVariable String id) throws ResourceNotFoundException {
        UserEntity user=businessService.getUser(id);
        UserDetailsResponse response=new UserDetailsResponse();
        response.setId(user.getUuid());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmailAddress(user.getEmail());
        response.setMobileNumber(user.getMobilePhone());
        response.setStatus(UserStatusType.valueOf(UserStatus.getEnum(user.getStatus()).name()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}