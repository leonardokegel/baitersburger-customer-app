package br.com.fiap.baitersburger.customer.infrastructure.web.exception;

import br.com.fiap.baitersburger.customer.domain.exception.CustomerAlreadyExistsException;
import br.com.fiap.baitersburger.customer.domain.exception.CustomerNotFoundException;
import br.com.fiap.baitersburger.customer.domain.exception.InvalidCpfException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(CustomerNotFoundException ex) {

        Map<String, Object> body = fillBody(ex.getMessage(), HttpStatus.NOT_FOUND.value());

        // Retorna um erro 404 com o objeto de erro
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(CustomerAlreadyExistsException ex) {

        Map<String, Object> body = fillBody(ex.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(InvalidCpfException ex) {

        Map<String, Object> body = fillBody(ex.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    private static Map<String, Object> fillBody(Object message, int status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status);
        body.put("message", message);
        return body;
    }
}
