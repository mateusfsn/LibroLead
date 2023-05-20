package com.finalproject.librolead.publishers.service;

import com.finalproject.librolead.publishers.dto.PublisherDTO;
import com.finalproject.librolead.publishers.entity.Publisher;
import com.finalproject.librolead.publishers.exception.PublisherAlreadyExistsException;
import com.finalproject.librolead.publishers.exception.PublisherNotFoundException;
import com.finalproject.librolead.publishers.mapper.PublisherMapper;
import com.finalproject.librolead.publishers.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public PublisherDTO findById(Long id) {
        return publisherRepository.findById(id)
                .map(publisherMapper::toDTO)
                .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    public List<PublisherDTO> findAll() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }
}
