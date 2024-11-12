package com.devsuperior.crud.client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidantionError extends CustomError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidantionError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public  void addError(String fieldName,String message){
        errors.add(new FieldMessage(fieldName,message));
    }
}
