package com.upendra_accio.bookManager;

import java.util.List;
import java.util.Optional;

public class BookServices {
    private BookRepository bookRepository=new BookRepository();

    public String addBook(Book book){
        bookRepository.add(book);
        return "book added with id:"+book.getId();
    }
    public Book getBook(String name) throws BookIdInvalidException{
     List<Book> books=bookRepository.getAll();
     for(Book book:books){
         if(book.getTitle().equals(name)){
             return book;
         }
     }
     throw new BookIdInvalidException(404);
    }
    public Book getBook(Integer id) throws BookIdInvalidException{
        Optional<Book> bookOptional=bookRepository.getById(id);
        if(bookOptional.isEmpty()){
            throw new BookIdInvalidException(id);
        }

            return  bookOptional.get();

    }
    public List<Book> getAllBook(){
        return bookRepository.getAll();
    }

    public Book updateBook(Integer id, Integer pages)throws RuntimeException {
        Book book=getBook(id);
        book.setPage(pages);
        bookRepository.update(book);
        return book;
    }

    public void removeBookById(Integer id) {
        bookRepository.removeBook(id);
    }
}
