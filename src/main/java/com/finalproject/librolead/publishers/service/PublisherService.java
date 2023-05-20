package com.finalproject.librolead.publishers.service;

import com.finalproject.librolead.publishers.dto.PublisherDTO;
import com.finalproject.librolead.publishers.entity.Publisher;
import com.finalproject.librolead.publishers.exception.PublisherAlreadyExistsException;
import com.finalproject.librolead.publishers.mapper.PublisherMapper;
import com.finalproject.librolead.publishers.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherService {

    private final static PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public PublisherDTO create(PublisherDTO publisherDTO) {
        Optional<Publisher> duplicatedPublisher = publisherRepository
                .findByNameOrCode(publisherDTO.getName(), publisherDTO.getCode());

        if(duplicatedPublisher.isPresent()) {
            throw new PublisherAlreadyExistsException(publisherDTO.getName(), publisherDTO.getCode());
        }

        Publisher publisherToCreate = publisherMapper.toModel(publisherDTO);
        Publisher createdPublisher = publisherRepository.save(publisherToCreate);
        return publisherMapper.toDTO(createdPublisher);
    }
}
