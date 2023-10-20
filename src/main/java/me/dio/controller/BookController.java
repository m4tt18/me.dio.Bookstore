package me.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.dio.Service.BookService;
import me.dio.domain.model.Book;

@RestController
@RequestMapping("/api/books")
@Api
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation ("Create new book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        var bookCreate = bookService.createBook(book);
        return ResponseEntity.ok(bookCreate);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> findAll(){
        var findAllBooks = bookService.findAllBooks();
        return ResponseEntity.ok(findAllBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        var findBook = bookService.findbyId(id);
        return ResponseEntity.ok(findBook);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

