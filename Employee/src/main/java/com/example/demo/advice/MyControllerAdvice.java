package com.example.demo.advice;
import com.example.demo.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<String> handleUserExceptions(UserException userException){
        return new ResponseEntity<String>(userException.getErrorMessage(), userException.getErrorCode());
    }
//    @ExceptionHandler(value = NoSuchElementException.class)
//    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
//        System.out.println("advise controller:  is started  :");
//        return new ResponseEntity<String>("THis  emp ID is not present in DB , please look into it.", HttpStatus.NOT_FOUND);
//    }
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return new ResponseEntity<Object>("please change http method type ", HttpStatus.NOT_FOUND);
}



