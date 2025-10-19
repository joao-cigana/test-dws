package dev.cigana.teste_dws.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<DefaultError> handleMyCustomException(RuntimeException ex) {
//        DefaultError err = new DefaultError(ex.getMessage(), LocalDateTime.now());
//        return ResponseEntity.internalServerError().body(err);
//    }

}
