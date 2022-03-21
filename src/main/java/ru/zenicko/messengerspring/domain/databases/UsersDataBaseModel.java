package ru.zenicko.messengerspring.domain.databases;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDataBaseModel {
    private String password;
    private long id;
    private String fio;
}
