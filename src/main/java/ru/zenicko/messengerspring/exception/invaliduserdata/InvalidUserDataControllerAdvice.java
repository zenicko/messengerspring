package ru.zenicko.messengerspring.exception.invaliduserdata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class InvalidUserDataControllerAdvice {

    @ExceptionHandler(InvalidUserDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(InvalidUserDataException exception) {
        return String.format("Status code %s \n %s\n", HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
