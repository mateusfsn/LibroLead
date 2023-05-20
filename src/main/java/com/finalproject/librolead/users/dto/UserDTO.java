package com.finalproject.librolead.users.dto;

import java.util.List;

import com.finalproject.librolead.users.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    @Max(120)
    private int age;

    @NotNull
    private Gender gender;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 255)
    private String password;

    @NotNull
    private LocalDate birthDate;

    private List<Long> bookIds;
}