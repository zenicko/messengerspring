package ru.zenicko.messengerspring.domain.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginInfo {
    private String username;
    private String password;

    public boolean isFullFio() {
        if (username == null ||
                username == "" ||
                username.length() <= 5
                //||                !fio.matches("\\w{5,}"

        ) return false;

        return true;
    }
    public boolean isFullPassword() {
        if (password == null ||
                password == "" ||
                password.length() <= 8
                //|| !password.matches("\\w{8,}"

        ) return false;

        return true;
    }

}
