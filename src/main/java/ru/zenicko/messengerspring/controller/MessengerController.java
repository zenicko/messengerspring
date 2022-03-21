package ru.zenicko.messengerspring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zenicko.messengerspring.domain.LoginInfo;
import ru.zenicko.messengerspring.domain.UserID;

@RestController
public class MessengerController {

    @PostMapping("user/login")
    public UserID doLogin(@RequestBody LoginInfo loginInfo) {

        return null;
    }

}
