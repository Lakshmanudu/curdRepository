package com.curdOperation.controller;
import java.util.List;

import com.curdOperation.Exception.BooKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.curdOperation.model.Books;
import com.curdOperation.service.BooksService;
@RestController
public class BooksController {
    @Autowired
    BooksService booksService;

    @GetMapping("/getPriceAndBook")
    private List<Books> getPriceAndBookName(@RequestParam("Price") int price,@RequestParam("BookName") String bookName) throws BooKException {
        return booksService.getPriceAndBookName(price,bookName);
    }

   @GetMapping("/getPriceLessThan")
    private List<Books> getPriceLessThan(@RequestParam("Price") int price) throws BooKException {
        return booksService.getPriceLessThan(price);
    }
    @GetMapping("/getPriceLessThanEqual")
    private List<Books> getPriceLessThanEqual(@RequestParam("Price") int price) throws BooKException {
        return booksService.getPriceLessThanEqual(price);
    }

//creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }
}
