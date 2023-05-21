//package com.finalproject.librolead.books.controller;
//
//import com.finalproject.librolead.books.dto.BookDTO;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import java.util.List;
//
//@Api("Books")
//public interface BookControllerDocs {
//
//    @ApiOperation(value = "Book creation operation")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Success book creation"),
//            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or book already registered on system"),
//            @ApiResponse(code = 404, message = "Author, Publisher or User not found"),
//            @ApiResponse(code = 500, message = "An unexpected error occurred")
//    })
//    BookDTO createBook(BookDTO bookDTO);
//
//    @ApiOperation(value = "Find book by ID operation")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success book found"),
//            @ApiResponse(code = 404, message = "Book not found"),
//            @ApiResponse(code = 500, message = "An unexpected error occurred")
//    })
//    BookDTO findBookById(Long id);
//
//    @ApiOperation(value = "List all books operation")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success, list all books"),
//            @ApiResponse(code = 500, message = "An unexpected error occurred")
//    })
//    List<BookDTO> listAll();
//
//    @ApiOperation(value = "Delete book by ID operation")
//    @ApiResponses(value = {
//            @ApiResponse(code = 204, message = "Success book deleted"),
//            @ApiResponse(code = 404, message = "Book not found"),
//            @ApiResponse(code = 500, message = "An unexpected error occurred")
//    })
//    void deleteById(Long id);
//}
