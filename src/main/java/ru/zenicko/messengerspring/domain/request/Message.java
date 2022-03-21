package ru.zenicko.messengerspring.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private long idFrom;
    private String userNameFrom;
    private long idTo;
    private String userNameTo;
    private String message;
}
