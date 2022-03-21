package ru.zenicko.messengerspring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zenicko.messengerspring.domain.request.LoginInfo;
import ru.zenicko.messengerspring.domain.response.UserID;
import ru.zenicko.messengerspring.domain.databases.UsersDataBaseModel;
import ru.zenicko.messengerspring.exception.invaliduserdata.InvalidUserDataException;

import static ru.zenicko.messengerspring.MessengerSpringApplication.usersDataBase;

@RestController
public class MessengerController {

    @PostMapping("user/new")
    public UserID doNewUser(@RequestBody LoginInfo loginInfo) throws Exception {
        UsersDataBaseModel user = new UsersDataBaseModel();

        if (loginInfo.isFullFio() && loginInfo.isFullPassword()) {
            user.setUserName(loginInfo.getUsername());
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



}

