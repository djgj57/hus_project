package io.hus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.apache.log4j.*;

@ControllerAdvice
public class GlobalExceptionHandler {

//    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
    final static Logger log = Logger.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allError(Exception ex, WebRequest req){

        log.error(ex.getMessage() + req.getDescription(true));
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
