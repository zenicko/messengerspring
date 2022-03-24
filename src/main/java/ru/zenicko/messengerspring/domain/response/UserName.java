package ru.zenicko.messengerspring.domain.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserName {
    private String userName;
}
