package com.finalproject.librolead.books.service;

import com.finalproject.librolead.author.repository.AuthorRepository;
import com.finalproject.librolead.author.entity.Author;
import com.finalproject.librolead.books.dto.BookDTO;
import com.finalproject.librolead.books.entity.Book;
import com.finalproject.librolead.books.exception.BookAlreadyExistsException;
import com.finalproject.librolead.books.exception.BookNotFoundException;
import com.finalproject.librolead.books.mapper.BookMapper;
import com.finalproject.librolead.books.repository.BookRepository;
import com.finalproject.librolead.publishers.entity.Publisher;
import com.finalproject.librolead.publishers.repository.PublisherRepository;
import com.finalproject.librolead.users.entity.User;
import com.finalproject.librolead.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private UserRepository userRepository;

    @Autowired
    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository,
                       UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.userRepository = userRepository;
    }

    public BookDTO create(BookDTO bookDTO) {
        verifyIfExists(bookDTO.getIsbn());

        Author author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author Not Found"));

        Publisher publisher = publisherRepository.findById(bookDTO.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Publisher Not Found"));

        User user = userRepository.findById(bookDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Book bookToCreate = bookMapper.toModel(bookDTO);
        bookToCreate.setAuthor(author);
        bookToCreate.setPublisher(publisher);
        bookToCreate.setUser(user);

        Book createdBook = bookRepository.save(bookToCreate);
        return bookMapper.toDTO(createdBook);
    }

    public BookDTO findById(Long id) {
        Book foundBook = verifyAndGetBook(id);
        return bookMapper.toDTO(foundBook);
    }

    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        verifyAndGetBook(id);
        bookRepository.deleteById(id);
    }

    private Book verifyAndGetBook(Long id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return foundBook;
    }

    private void verifyIfExists(String isbn) {
        bookRepository.findByIsbn(isbn)
                .ifPresent(book -> {
                    throw new BookAlreadyExistsException(isbn);
                });
    }
}