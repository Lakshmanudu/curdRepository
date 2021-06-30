package com.curdOperation.service;

import com.curdOperation.Exception.BooKException;
import com.curdOperation.model.Books;
import com.curdOperation.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService
{
        @Autowired
        BooksRepository booksRepository;

        //getting all books record by using the method findaAll() of CrudRepository
        public List<Books> getAllBooks() {
                List<Books> books = new ArrayList<Books>();
                booksRepository.findAll().forEach(books1 -> books.add(books1));
                return books;
        }

        //getting a specific record by using the method findById() of CrudRepository
        public Books getBooksById(int id) {
                return booksRepository.findById(id).get();
        }

        //saving a specific record by using the method save() of CrudRepository
        public void saveOrUpdate(Books books) {
                booksRepository.save(books);
        }

        //deleting a specific record by using the method deleteById() of CrudRepository
        public void delete(int id) {
                booksRepository.deleteById(id);
        }

        //updating a record
        public void update(Books books, int bookid) {
                booksRepository.save(books);
        }

    public List<Books> getPriceAndBookName(int price,String bookName) throws BooKException{

            Optional<List<Books>> byPriceOrBookName = booksRepository.findByPriceAndBookname(price, bookName);

            if(byPriceOrBookName.isPresent() && byPriceOrBookName.get().size() > 0 )
            {
                  return (List<Books>) byPriceOrBookName.get();
            }
            else
            {
                    throw new BooKException("The given price & book combination Not found");
            }

    }
        public List<Books> getPriceLessThan(int price) throws BooKException{

                Optional<List<Books>> byPriceLessThan = booksRepository.findByPriceLessThan(price);

                if(byPriceLessThan.isPresent() && byPriceLessThan.get().size() > 0 )
                {
                        return (List<Books>) byPriceLessThan.get();
                }
                else
                {
                        throw new BooKException("The given price greater than book price please check once");
                }

        }
        public List<Books> getPriceLessThanEqual(int price) throws BooKException{

                Optional<List<Books>> byPriceLessThanEqual = booksRepository.findByPriceLessThanEqual(price);

                if(byPriceLessThanEqual.isPresent() && byPriceLessThanEqual.get().size() > 0 )
                {
                        return (List<Books>) byPriceLessThanEqual.get();
                }
                else
                {
                        throw new BooKException("The given price less than the  book price please check once");
                }

        }


}
