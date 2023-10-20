package me.dio.Service;

import java.util.List;

import me.dio.domain.model.Book;

public interface BookService {


    Book createBook(Book bookToCreate);

    List<Book> findAllBooks();

    Book findbyId(Long id);

    void deleteById(Long id);
    
}
