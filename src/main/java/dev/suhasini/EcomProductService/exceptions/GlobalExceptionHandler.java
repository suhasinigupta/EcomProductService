package dev.suhasini.EcomProductService.exceptions;

import dev.suhasini.EcomProductService.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

      @ExceptionHandler(ProductNotFoundException.class)
      public ResponseEntity<ErrorDto> productNotFoundException(ProductNotFoundException exception){
           ErrorDto errorDto = new ErrorDto();
           errorDto.setStatus("Failure");
           errorDto.setMessage(exception.getMessage());
           return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND) ;
      }
}
