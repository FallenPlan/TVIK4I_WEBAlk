package hu.iit.me.webalk.db.controller;

import hu.iit.me.webalk.db.service.NoSuchEntityException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NoSuchEntityException.class)
    protected ResponseEntity<Object> HandleNoSuchElement (
        RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new httpHandler(), )
    }
}
