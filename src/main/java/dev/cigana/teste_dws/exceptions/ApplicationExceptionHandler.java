package dev.cigana.teste_dws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

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


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<DefaultError> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String paramName = ex.getName();
        Class<?> requiredType = ex.getRequiredType();
        if (requiredType != null && requiredType.isEnum()) {
            String invalidValue = ex.getValue() != null ? ex.getValue().toString() : "null";
            String enumTypes = Arrays.stream(requiredType.getEnumConstants())
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            String errorMessage = "valor '" + invalidValue + "' informado para o parâmetro '" + paramName + "'  é inválido. Informe um dos seguintes: " + enumTypes;
            DefaultError de = new DefaultError(errorMessage, LocalDateTime.now());
            return ResponseEntity.badRequest().body(de);
        }

        DefaultError de = new DefaultError("Tipo de argumento (" + paramName  + ") inválido.", LocalDateTime.now());
        return ResponseEntity.badRequest().body(de);
    }

}
