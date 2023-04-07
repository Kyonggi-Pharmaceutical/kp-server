package kr.ac.kgu.kpserver.handler;

import kr.ac.kgu.kpserver.util.KpErrorResponse;
import kr.ac.kgu.kpserver.util.KpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(KpException.class)
    public ResponseEntity<?> handleKpException(KpException exception) {

        String errorMessage;

        if (exception.message != null) {
            errorMessage = exception.message;
        } else {
            errorMessage = exception.exceptionType.errorMessage;
        }

        return ResponseEntity
                .status(exception.exceptionType.httpStatus)
                .body(new KpErrorResponse(exception.exceptionType.errorCode, errorMessage));
    }

}
