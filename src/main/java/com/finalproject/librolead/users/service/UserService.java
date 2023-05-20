package com.finalproject.librolead.users.service;

import com.finalproject.librolead.users.dto.UserDTO;
import com.finalproject.librolead.users.entity.User;
import com.finalproject.librolead.users.exception.UserAlreadyExistsException;
import com.finalproject.librolead.users.exception.UserNotFoundException;
import com.finalproject.librolead.users.mapper.UserMapper;
import com.finalproject.librolead.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserDTO userDTO) {
        verifyIfExists(userDTO.getUsername());

        User userToCreate = userMapper.toModel(userDTO);
        User createdUser = userRepository.save(userToCreate);
        return userMapper.toDTO(createdUser);
    }

    public UserDTO findById(Long id) {
        User foundUser = verifyAndGetUser(id);
        return userMapper.toDTO(foundUser);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        verifyAndGetUser(id);
        userRepository.deleteById(id);
    }

    private User verifyAndGetUser(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return foundUser;
    }

    private void verifyIfExists(String username) {
        userRepository.findByName(username)
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException(username);
                });
    }
}
