package ru.zenicko.messengerspring.exception.invaliduserdata;

public class InvalidUserDataException extends RuntimeException {
    public InvalidUserDataException() {
        super("The username or/and password is incorrect.");
    }
}
