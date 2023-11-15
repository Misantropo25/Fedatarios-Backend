package com.fedatarios.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    protected ResponseEntity<Object> handleAppException(AppException ex, WebRequest request) {
        // Construir una respuesta adecuada para la excepción
        return "Error dentro de rest exception rest handler";
    }

    // Otros manejadores de excepciones
}
