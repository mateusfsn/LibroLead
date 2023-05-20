package com.finalproject.librolead.books.mapper;

import com.finalproject.librolead.books.dto.BookDTO;
import com.finalproject.librolead.books.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
