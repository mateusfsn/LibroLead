package com.finalproject.librolead.books.mapper;

import com.finalproject.librolead.books.dto.BookRequestDTO;
import com.finalproject.librolead.books.dto.BookResponseDTO;
import com.finalproject.librolead.books.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookRequestDTO bookRequestDTO);

    Book toModel(BookResponseDTO bookRequestDTO);

    BookResponseDTO toDTO(Book book);
}
