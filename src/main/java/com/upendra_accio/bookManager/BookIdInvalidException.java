package com.upendra_accio.bookManager;

public class BookIdInvalidException extends RuntimeException{
    public BookIdInvalidException(Integer id){
        super("book not present by id:"+id);
    }

}
