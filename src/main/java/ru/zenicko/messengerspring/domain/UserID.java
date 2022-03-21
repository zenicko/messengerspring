package ru.zenicko.messengerspring.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserID {
    private long id;
}
