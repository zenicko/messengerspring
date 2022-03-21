package ru.zenicko.messengerspring.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginInfo {
    private String fio;
    private String password;
}
