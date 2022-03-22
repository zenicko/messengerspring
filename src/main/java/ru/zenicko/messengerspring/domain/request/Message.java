package ru.zenicko.messengerspring.domain.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Message {
    private long idFrom;
    private String userNameFrom;
    private long idTo;
    private String userNameTo;
    private String message;
}
