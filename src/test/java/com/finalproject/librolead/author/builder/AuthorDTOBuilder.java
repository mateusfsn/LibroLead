package com.finalproject.librolead.author.builder;

import com.finalproject.librolead.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Mateus Costa";

    @Builder.Default
    private final int age = 22;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);
    }
}
