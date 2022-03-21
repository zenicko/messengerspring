package ru.zenicko.messengerspring.domain.databases;

import lombok.*;
import ru.zenicko.messengerspring.domain.request.LoginInfo;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDataBaseModel extends LoginInfo {
    private long id;
}
