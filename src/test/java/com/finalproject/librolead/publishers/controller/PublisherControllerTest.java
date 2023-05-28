package com.finalproject.librolead.publishers.controller;

import com.finalproject.librolead.publishers.builder.PublisherDTOBuilder;
import com.finalproject.librolead.publishers.dto.PublisherDTO;
import com.finalproject.librolead.publishers.service.PublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static com.finalproject.librolead.utils.JsonConversionUtils.asJsonString;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class PublisherControllerTest {

    private final static String PUBLISHERS_API_URL_PATH = "/api/v1/publishers";

    private MockMvc mockMvc;

    @Mock
    private PublisherService publisherService;

    @InjectMocks
    private PublisherController publisherController;

    private PublisherDTOBuilder publisherDTOBuilder;

    @BeforeEach
    void setUp() {
        publisherDTOBuilder = PublisherDTOBuilder.builder().build();
        mockMvc = standaloneSetup(publisherController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenCreatedStatusShouldBeInformed() throws Exception {
        PublisherDTO expectedCreatedPublisherDTO = publisherDTOBuilder.buildPublisherDTO();

        when(publisherService.create(expectedCreatedPublisherDTO)).thenReturn(expectedCreatedPublisherDTO);

        mockMvc.perform(post(PUBLISHERS_API_URL_PATH)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(expectedCreatedPublisherDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(expectedCreatedPublisherDTO.getId().intValue())))
                .andExpect(jsonPath("$.name", is(expectedCreatedPublisherDTO.getName())))
                .andExpect(jsonPath("$.code", is(expectedCreatedPublisherDTO.getCode())));

    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldsThenBadRequestStatusShouldBeInformed() throws Exception {
        PublisherDTO expectedCreatedPublisherDTO = publisherDTOBuilder.buildPublisherDTO();
        expectedCreatedPublisherDTO.setName(null);

        mockMvc.perform(post(PUBLISHERS_API_URL_PATH)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(expectedCreatedPublisherDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenGETWithValidIdIsCalledThenOkStatusShouldBeInformed() throws Exception {
        PublisherDTO expectedCreatedPublisherDTO = publisherDTOBuilder.buildPublisherDTO();
        Long expectedCreatedPublisherDTOId = expectedCreatedPublisherDTO.getId();

        when(publisherService.findById(expectedCreatedPublisherDTOId)).thenReturn(expectedCreatedPublisherDTO);

        mockMvc.perform(get(PUBLISHERS_API_URL_PATH + "/" + expectedCreatedPublisherDTOId)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(expectedCreatedPublisherDTOId.intValue())))
                .andExpect(jsonPath("$.name", is(expectedCreatedPublisherDTO.getName())))
                .andExpect(jsonPath("$.code", is(expectedCreatedPublisherDTO.getCode())));

    }

    @Test
    void whenGETListIsCalledThenOkStatusShouldBeInformed() throws Exception {
        PublisherDTO expectedCreatedPublisherDTO = publisherDTOBuilder.buildPublisherDTO();

        when(publisherService.findAll()).thenReturn(singletonList(expectedCreatedPublisherDTO));

        mockMvc.perform(get(PUBLISHERS_API_URL_PATH)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(expectedCreatedPublisherDTO.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(expectedCreatedPublisherDTO.getName())))
                .andExpect(jsonPath("$[0].code", is(expectedCreatedPublisherDTO.getCode())));

    }

    @Test
    void whenDELETEIsCalledThenNoContentStatusShouldBeInformed() throws Exception {
        PublisherDTO expectedPublisherToDelete = publisherDTOBuilder.buildPublisherDTO();
        var expectedPublisherIdToDelete = expectedPublisherToDelete.getId();

        doNothing().when(publisherService).delete(expectedPublisherIdToDelete);

        mockMvc.perform(delete(PUBLISHERS_API_URL_PATH + "/" + expectedPublisherIdToDelete)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}