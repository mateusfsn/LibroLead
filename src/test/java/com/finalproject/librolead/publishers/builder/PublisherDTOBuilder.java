package com.finalproject.librolead.publishers.builder;

import com.finalproject.librolead.publishers.dto.PublisherDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PublisherDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    private final String name = "Costa Editora";

    private final String code = "COSTA1234";

    private final LocalDate foundationDate = LocalDate.of(2023, 5, 26);

    public PublisherDTO buildPublisherDTO() {
        return new PublisherDTO(
                id,
                name,
                code,
                foundationDate);
    }
}