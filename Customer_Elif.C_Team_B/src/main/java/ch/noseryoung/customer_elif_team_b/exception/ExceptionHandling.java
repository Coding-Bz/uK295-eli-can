package ch.noseryoung.customer_elif_team_b.exception;

import org.hibernate.StaleObjectStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionHandling {


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request konnte nicht gelesen werden" );
    }


    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<String> handleNoSuchMethodException(HttpMessageNotReadableException me) {  //400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(me.getMessage());
    }

    @ExceptionHandler(NoSuchFieldError.class)
    public ResponseEntity<String> handleNoSuchFieldException(HttpMessageNotReadableException me) { //400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(me.getMessage());
    }
    @ExceptionHandler(StaleObjectStateException.class)
    public ResponseEntity<String> handleStaleObjectStateException(StaleObjectStateException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }




}


