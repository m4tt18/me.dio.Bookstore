package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    boolean existsById(Long id);
    
}
