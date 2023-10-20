package me.dio.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.Service.BookService;
import me.dio.domain.model.Book;
import me.dio.domain.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book bookToCreate) {       
        if (bookRepository.existsById(bookToCreate.getId())){
            throw new IllegalArgumentException("This book is already created in system...");
        }
        return bookRepository.save(bookToCreate);
    }

    public List<Book> findAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book findbyId(Long id){
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}
