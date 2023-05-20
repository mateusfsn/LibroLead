//package com.finalproject.librolead.books.controller;
//
//import com.finalproject.librolead.books.dto.BookDTO;
//import com.finalproject.librolead.books.service.BookService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/books")
//@Api(tags = "Books")
//public class BookController implements BookControllerDocs {
//
//    private final BookService bookService;
//
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) {
//        return bookService.create(bookDTO);
//    }
//
//    @GetMapping("/{id}")
//    public BookDTO findBookById(@PathVariable Long id) {
//        return bookService.findById(id);
//    }
//
//    @GetMapping
//    public List<BookDTO> listAll() {
//        return bookService.findAll();
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable Long id) {
//        bookService.delete(id);
//    }
//}
