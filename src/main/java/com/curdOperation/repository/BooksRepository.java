package com.curdOperation.repository;

import com.curdOperation.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    public Optional<List<Books>>findByPriceLessThan(int price);

    public Optional<List<Books>> findByPriceLessThanEqual(int price);

    public Optional<Books> findByPriceOrBookname(int price, String bookName);

    public Optional<List<Books>> findByPriceAndBookname(int price,String bookName);

    public List<Books> findByBooknameBetween(String start, String end);

    public List<Books> findByPriceGreaterThanEqual(int Price);

    public List<Books> findByBooknameIsNull();

    public List<Books> findByBooknameOrBooknameIsNull(String name);

    public List<Books> findByBooknameLike(String name);

    public List<Books> findByBooknameContaining(String name);

    public List<Books> findByBooknameStartingWith(String name);

}
