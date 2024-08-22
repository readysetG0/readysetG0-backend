package com.readysetgo.traveltracker.common.exception;

import static com.readysetgo.traveltracker.common.util.ApiUtils.error;

import com.readysetgo.traveltracker.common.util.ApiUtils.ApiResult;
import jakarta.validation.ConstraintViolationException;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler {

    private final MessageSource messageSource;

    private ResponseEntity<ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
        return newResponse(throwable.getMessage(), status);
    }

    private ResponseEntity<ApiResult<?>> newResponse(String message, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(error(message, status), headers, status);
    }

    @ExceptionHandler({NoHandlerFoundException.class, NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(Exception e) {
        return newResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            UsernameNotFoundException.class,
            BadCredentialsException.class
    })
    public ResponseEntity<?> handleLoginException(Exception e) {
        return newResponse("Bad Credential", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            IllegalStateException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
    })
    public ResponseEntity<?> handleBadRequestException(Exception e) {
        log.debug("Bad request exception occurred: {}", e.getMessage(), e);

        if (e instanceof MethodArgumentNotValidException) {
            return newResponse(
                    getErrorMessage(((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0)),
                    HttpStatus.BAD_REQUEST);
        }

        return newResponse(e, HttpStatus.BAD_REQUEST);
    }

    private String getErrorMessage(ObjectError error) {
        for (String code : error.getCodes()) {
            try {
                return messageSource.getMessage(code, error.getArguments(), Locale.KOREA);
            } catch (NoSuchMessageException ignored) {
            }
        }

        return error.getDefaultMessage();
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<?> handleHttpMediaTypeException(Exception e) {
        return newResponse(e, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotAllowedException(Exception e) {
        return newResponse(e, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(Exception e) {
        return newResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        return newResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
