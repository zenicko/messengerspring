package ru.zenicko.messengerspring.exception.invalisiduser;

public class UserIsNotExistException extends RuntimeException {
    public UserIsNotExistException(String userID) {
        super(String.format("User with ID %s is not exist", userID));
    }
}
