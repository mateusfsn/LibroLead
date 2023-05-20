package com.finalproject.librolead.users.controller;

import com.finalproject.librolead.users.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Manages User")
public interface UserControllerDocs {

    @ApiOperation(value = "User creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success User creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field value")
    })
    UserDTO createUser(UserDTO userDTO);

    @ApiOperation(value = "Find a specific User by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success User found"),
            @ApiResponse(code = 404, message = "User with given id not found")
    })
    UserDTO findUserById(Long id);

    @ApiOperation(value = "List all registered Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List all Users")
    })
    List<UserDTO> listAll();

    @ApiOperation(value = "Delete a User found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success User deleted"),
            @ApiResponse(code = 404, message = "User with given id not found")
    })
    void deleteById(Long id);
}
