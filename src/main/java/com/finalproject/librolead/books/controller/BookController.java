package com.finalproject.librolead.books.controller;

import com.finalproject.librolead.books.dto.BookDTO;
import com.finalproject.librolead.books.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Api(tags = "Books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new book", notes = "Provide ISBN, Name, Pages, Chapters, AuthorId, PublisherId and UserId")
    public BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a book by its id", notes = "Provide an id to look up specific book")
    public BookDTO findBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Get all books", notes = "No input is needed to get all books")
    public List<BookDTO> listAll() {
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a book", notes = "Provide an id to delete a specific book")
    public void deleteById(@PathVariable Long id) {
        bookService.delete(id);
    }
}
