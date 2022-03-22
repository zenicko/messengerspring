package ru.zenicko.messengerspring.exception.invalisiduser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class UserIsNotExistControllerAdvice {

    @ExceptionHandler(UserIsNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(UserIsNotExistException exception) {

        return String.format("The status code is %s. \n %s", HttpStatus.BAD_REQUEST, exception.getMessage());
    }

}
