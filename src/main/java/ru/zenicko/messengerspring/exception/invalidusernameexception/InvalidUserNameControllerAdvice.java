package ru.zenicko.messengerspring.exception.invalidusernameexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class InvalidUserNameControllerAdvice {

    @ExceptionHandler(InvalidUserNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(InvalidUserNameException exception) {
        return String.format("The status code is %s \n %s", HttpStatus.BAD_REQUEST, exception.getMessage());
    }

}
