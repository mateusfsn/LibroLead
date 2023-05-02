package com.finalproject.librolead.author.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.finalproject.librolead.author.builder.AuthorDTOBuilder;
import com.finalproject.librolead.author.dto.AuthorDTO;
import com.finalproject.librolead.author.service.AuthorService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(authorController)
                .setCustomArgumentResolvers((new PageableHandlerMethodArgumentResolver()))
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();

        Mockito.when(authorService.create(expectedCreatedAuthorDTO))
                .thenReturn(expectedCreatedAuthorDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedAuthorDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(expectedCreatedAuthorDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(expectedCreatedAuthorDTO.getAge())));
    }

    private static String asJsonString(AuthorDTO expectedCreatedAuthorDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(expectedCreatedAuthorDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldThenBadRequestStatusShouldBeInformed() throws Exception {
        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();
        expectedCreatedAuthorDTO.setName(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
