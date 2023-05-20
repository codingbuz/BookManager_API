package com.upendra_accio.bookManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

   // Map<Integer,Book> bookData=new HashMap<>();

  private BookServices bookservices=new BookServices();
//    @PostMapping("/add-book")
//    public String addBook(@RequestBody Book book){
//       // bookData.put(book.getId(),book);
//        String str=bookservices.addBook(book);
//        return str;
//    }

    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        // bookData.put(book.getId(),book);
        String str=bookservices.addBook(book);
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }


//  @GetMapping("/get-book")
//    public Book getBook(@RequestParam  Integer id){
//        try{
//            Book book=bookservices.getBook((id));
//            return book;
//        }catch (BookIdInvalidException ex){
//            System.out.println("book did not find");
//            return null;
//        }
//
//    }
@GetMapping("/get-book")
public ResponseEntity<Book> getBook(@RequestParam  Integer id){
    try{
        Book book=bookservices.getBook((id));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }catch (BookIdInvalidException ex){
        System.out.println("book did not find");
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}

    @GetMapping("/get-all-book")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookservices.getAllBook(),HttpStatus.OK);
    }


    @GetMapping("/get-book-by-name/{name}")
    public ResponseEntity<Book> getBookByName( @PathVariable String name) {
        try {
            return new ResponseEntity<>(bookservices.getBook(name),HttpStatus.OK);
        }catch (BookIdInvalidException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

     @PutMapping("/update-page")
    public ResponseEntity<Book> updateBookPages(@RequestParam  Integer id,@RequestParam Integer pages){
        try {
            Book book = bookservices.updateBook(id, pages);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


     }

     @DeleteMapping("/delete-book")
    public String deleteBook(@RequestParam Integer id){
        bookservices.removeBookById(id);
        return "delete book with id"+id;
     }


}
