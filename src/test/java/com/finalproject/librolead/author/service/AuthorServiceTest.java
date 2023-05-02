package com.finalproject.librolead.author.service;

import com.finalproject.librolead.author.builder.AuthorDTOBuilder;
import com.finalproject.librolead.author.dto.AuthorDTO;
import com.finalproject.librolead.author.entity.Author;
import com.finalproject.librolead.author.exception.AuthorAlreadyExistsException;
import com.finalproject.librolead.author.mapper.AuthorMapper;
import com.finalproject.librolead.author.repository.AuthorRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }

    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated() {
        //given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        //when
        Mockito.when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
        Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName())).thenReturn(Optional.empty());

        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreateDTO);

        //then
        MatcherAssert.assertThat(createdAuthorDTO, Is.is(IsEqual.equalTo(expectedAuthorToCreateDTO)));
    }

    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName()))
                .thenReturn(Optional.of(expectedCreatedAuthor));

        Assertions.assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDTO));
    }
}