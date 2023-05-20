package com.finalproject.librolead.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 13)
    private String isbn;

    @NotNull
    @Max(10000)
    private Integer pages;

    @NotNull
    @Max(1000)
    private Integer chapters;

    private Long authorId;

    private Long publisherId;

    private Long userId;
}
