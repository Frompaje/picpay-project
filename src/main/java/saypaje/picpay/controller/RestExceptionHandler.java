package saypaje.picpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import saypaje.picpay.exceptions.PicPayException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayException(PicPayException exception) {
        return exception.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var fieldErros = exception.getFieldErrors().stream().map(fieldError -> new invalidParams(fieldError.getField(), fieldError.getDefaultMessage())
        ).toList();

        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setTitle("Your request parameters didn't validate.");
        problemDetail.setProperty("Invalid-params", fieldErros);
        return problemDetail;
    }

    private record invalidParams(String fieldName, String reason) {
    };

}
