package com.devsuperior.crud.client.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException (String msg){
        super(msg);
    }
}
