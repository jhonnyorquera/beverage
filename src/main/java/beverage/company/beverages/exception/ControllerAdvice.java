package beverage.company.beverages.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//RestControllerAdvice annotation is a combination of ControllerAdvice and Responsebody.
//Used in Java to create global exception handlers for RESTful APIs.
@RestControllerAdvice
public class ControllerAdvice
{

  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
    ErrorDto errorDto = ErrorDto.builder().code("P-500").message(ex.getMessage()!=null ? ex.getMessage(): "error en aplicacion").build();
    return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
  }


}
