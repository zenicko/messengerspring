package ru.zenicko.messengerspring.domain.databases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zenicko.messengerspring.domain.request.Message;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesDataBaseModel extends Message {
    private Data data;
}

