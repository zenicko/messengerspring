package ru.zenicko.messengerspring.domain.databases;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.zenicko.messengerspring.domain.request.Message;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MessagesDataBaseModel extends Message {
    private Date date;
}

