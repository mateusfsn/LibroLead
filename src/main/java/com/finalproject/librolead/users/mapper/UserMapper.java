package com.finalproject.librolead.users.mapper;

import com.finalproject.librolead.users.dto.UserDTO;
import com.finalproject.librolead.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);
}