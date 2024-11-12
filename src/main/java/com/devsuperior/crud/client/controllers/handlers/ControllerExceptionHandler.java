package com.devsuperior.crud.client.controllers.handlers;

import com.devsuperior.crud.client.dto.CustomError;
import com.devsuperior.crud.client.dto.ValidantionError;
import com.devsuperior.crud.client.services.exceptions.DatabaseException;
import com.devsuperior.crud.client.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;// erro 204
        CustomError err = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;//400 Bad Request é usado quando o servidor não consegue processar a solicitação devido a um problema com os dados enviados pelo cliente, como parâmetros inválidos, formato de dados incorreto, etc.
        CustomError err = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> MethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;//422 O cliente fez uma requisição válida, mas os dados contêm problemas que impedem o processamento
        ValidantionError erro = new ValidantionError(Instant.now(),status.value(),"Dados inválidos",request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()){
            erro.addError(f.getField(),f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(erro);
    }
}
