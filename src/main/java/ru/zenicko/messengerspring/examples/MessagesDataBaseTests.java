package ru.zenicko.messengerspring.examples;

import ru.zenicko.messengerspring.databases.MessagesDataBase;
import ru.zenicko.messengerspring.databases.UsersDataBase;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;
import ru.zenicko.messengerspring.domain.databases.UsersDataBaseModel;

import java.util.Date;
import java.util.Locale;

public class MessagesDataBaseTests {
    public static MessagesDataBase messagesDataBase;
    public static UsersDataBase usersDataBase;

    static public void main(String arg[]) throws Exception {
        usersDataBase = new UsersDataBase();
        messagesDataBase = new MessagesDataBase(usersDataBase);

        UsersDataBaseModel usersDataBaseModel =
                UsersDataBaseModel.builder().
                        id(1l).
                        username("Nick Petrov").
                        password("1234567879").
                        build();
        usersDataBase.insert(usersDataBaseModel);

        UsersDataBaseModel usersDataBaseModel1 =
                UsersDataBaseModel.builder().
                        id(2l).
                        username("Peter Ivanov").
                        password("987654321").
                        build();
        usersDataBase.insert(usersDataBaseModel1);

        MessagesDataBaseModel messagesDataBaseModel =
                MessagesDataBaseModel.builder().
                        date(new Date()).
                        idTo(1l).
                        userNameTo("a1").
                        idFrom(2l).
                        userNameFrom("b1").
                        message("AAAA222").
                        build();
        MessagesDataBaseModel messagesDataBaseModel1 =
                MessagesDataBaseModel.builder().
                        date(new Date()).
                        idTo(2l).
                        userNameTo("b1").
                        idFrom(1l).
                        userNameFrom("a1").
                        message("BBBBB222").
                        build();
        messagesDataBase.insert(messagesDataBaseModel);
        messagesDataBase.insert(messagesDataBaseModel1);
    }

}
