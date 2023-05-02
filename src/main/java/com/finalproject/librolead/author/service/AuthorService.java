package com.finalproject.librolead.author.service;

import com.finalproject.librolead.author.dto.AuthorDTO;
import com.finalproject.librolead.author.entity.Author;
import com.finalproject.librolead.author.exception.AuthorAlreadyExistsException;
import com.finalproject.librolead.author.mapper.AuthorMapper;
import com.finalproject.librolead.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        authorRepository.findByName(authorDTO.getName())
                .ifPresent(author -> {
                    throw new AuthorAlreadyExistsException(authorDTO.getName());
                });

        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }
}