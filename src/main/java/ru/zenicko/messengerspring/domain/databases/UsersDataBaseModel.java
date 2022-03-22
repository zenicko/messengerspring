package ru.zenicko.messengerspring.domain.databases;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.zenicko.messengerspring.domain.request.LoginInfo;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UsersDataBaseModel extends LoginInfo {
    private long id;
}
