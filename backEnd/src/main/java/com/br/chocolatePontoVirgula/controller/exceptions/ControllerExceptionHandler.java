package com.br.chocolatePontoVirgula.controller.exceptions;

import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotCreatedException;
import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError err=new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Recurso não encontrado");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(EntityNotCreatedException.class)
    public ResponseEntity<StandardError> entityNotCreated(EntityNotCreatedException e, HttpServletRequest request){
        StandardError err=new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
        err.setError("Recurso/Entidade não criada");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(err);
    }
}
