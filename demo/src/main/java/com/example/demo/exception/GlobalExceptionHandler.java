//package com.example.demo.exception;
//
//
//import com.example.demo.dto.response.ResponseObject;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ResponseObject> handleEntityNotFoundException(EntityNotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ResponseObject("404", ex.getMessage(), null));
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ResponseObject> handleIllegalArgumentException(IllegalArgumentException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(new ResponseObject("400", ex.getMessage(), null));
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ResponseObject> handleGlobalException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ResponseObject("500", "Internal Server Error", null));
//    }
//
//}
