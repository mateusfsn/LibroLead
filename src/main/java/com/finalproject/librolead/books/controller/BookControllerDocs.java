package com.finalproject.librolead.books.controller;

import com.finalproject.librolead.books.dto.BookDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api("Books")
public interface BookControllerDocs {

    @ApiOperation(value = "Book creation operation", notes = "Provide ISBN, Name, Pages, Chapters, AuthorId, PublisherId and UserId")
    BookDTO createBook(BookDTO bookDTO);

    @ApiOperation(value = "Find book by ID operation", notes = "Provide an id to look up specific book")
    BookDTO findBookById(Long id);

    @ApiOperation(value = "List all books operation", notes = "No input is needed to get all books")
    List<BookDTO> listAll();

    @ApiOperation(value = "Delete book by ID operation", notes = "Provide an id to delete a specific book")
    void deleteById(Long id);

}
