package ru.zenicko.messengerspring.domain.databases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesDataBaseModel {
    private Data data;
    private long idFrom;
    private String userNameFrom;
    private long idTo;
    private String userNameTo;
    private String message;

}

