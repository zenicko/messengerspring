package ru.zenicko.messengerspring.exception.invalidusernameexception;

import ru.zenicko.messengerspring.domain.response.UserID;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException(UserID userId) {
        super("The user with ID = " + userId.getId() + " is not exist");
    }
}
