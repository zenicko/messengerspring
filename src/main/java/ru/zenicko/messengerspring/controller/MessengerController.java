package ru.zenicko.messengerspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;
import ru.zenicko.messengerspring.domain.databases.UsersDataBaseModel;
import ru.zenicko.messengerspring.domain.request.LoginInfo;
import ru.zenicko.messengerspring.domain.request.Message;
import ru.zenicko.messengerspring.domain.response.Messages;
import ru.zenicko.messengerspring.domain.response.UserID;
import ru.zenicko.messengerspring.domain.response.UserName;
import ru.zenicko.messengerspring.exception.invalidusernameexception.InvalidUserNameException;
import ru.zenicko.messengerspring.exception.invalisiduser.UserIsNotExistException;
import ru.zenicko.messengerspring.exception.invaliduserdata.InvalidUserDataException;

import java.util.Date;

import static ru.zenicko.messengerspring.MessengerSpringApplication.messagesDataBase;
import static ru.zenicko.messengerspring.MessengerSpringApplication.usersDataBase;

@RestController
public class MessengerController {

    @PostMapping("user/new")
    public UserID doNewUser(@RequestBody LoginInfo loginInfo) throws Exception {
        UsersDataBaseModel user = new UsersDataBaseModel();

        if (loginInfo.isFullFio() && loginInfo.isFullPassword()) {
            user.setUsername(loginInfo.getUsername());
            user.setPassword(loginInfo.getPassword());
            user.setId(usersDataBase.getID());
            usersDataBase.insert(user);

            return UserID.
                    builder().
                    id(user.getId()).
                    build();
        } else {
            throw new InvalidUserDataException();
        }
    }

    @GetMapping("user/id")
    public UserName getUserID(@RequestBody UserID userID) throws Exception {
        UserName userName = usersDataBase.getUserName(userID.getId());
        if (userName == null)
            throw new UserIsNotExistException(String.valueOf(userID.getId()));

        return userName;

    }

    @PostMapping("message")
    public void sendMessage(@RequestBody Message message) throws Exception {
        MessagesDataBaseModel messagesDataBaseModel =
                MessagesDataBaseModel.builder().
                        date(new Date()).
                        idFrom(message.getIdFrom()).
                        userNameFrom(message.getUserNameFrom()).
                        idTo(message.getIdTo()).
                        userNameTo(message.getUserNameTo()).
                        message(message.getMessage()).
                        build();

        messagesDataBase.insert(messagesDataBaseModel);
    }
    @GetMapping("message/id")
    public Messages getMessages(@RequestBody UserID userId) throws Exception {

        Messages messages = messagesDataBase.getMessages(userId);
        if (messages.getMessages().isEmpty()) throw new InvalidUserNameException(userId);

        return messages;

    }

}

