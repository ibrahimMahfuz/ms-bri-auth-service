package id.co.pcsindonesia.ea.bri.authservice.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

//    @ExceptionHandler(ConversionFailedException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleConnversion(RuntimeException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(BookNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleBookNotFound(RuntimeException ex) {
//       return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
}