package ru.zenicko.messengerspring.domain.databases;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDataBaseModel {
    private long id;
    private String userName;
    private String password;
}
