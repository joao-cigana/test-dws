package dev.cigana.teste_dws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DefaultError> serverError(RuntimeException ex) {
        DefaultError err = new DefaultError("Erro interno do servidor", LocalDateTime.now());
        return ResponseEntity.internalServerError().body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DefaultError> resourceNotFound(ResourceNotFoundException ex) {
        DefaultError err = new DefaultError(ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
