package ru.zenicko.messengerspring.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Messages {

    private List<MessagesDataBaseModel> messages;

    public Messages() {
        messages = new ArrayList<MessagesDataBaseModel>();
    }

    public void add(MessagesDataBaseModel messageModel) {
        this.messages.add(messageModel);
    }
}
