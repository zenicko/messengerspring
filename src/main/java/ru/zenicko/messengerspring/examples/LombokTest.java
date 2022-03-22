package ru.zenicko.messengerspring.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;

import java.util.Arrays;
import java.util.Date;

public class LombokTest {
    public String[] fromModelToList(MessagesDataBaseModel messagesDataBaseModel) {
        Arrays.stream(Arrays.stream(messagesDataBaseModel.getClass().getDeclaredFields()).toArray()).peek(System.out::println);

        return null;
    }

    static public void main(String arg[]) throws JsonProcessingException {
        MessagesDataBaseModel messagesDataBaseModel = new MessagesDataBaseModel();

        messagesDataBaseModel.setDate(new Date());
        messagesDataBaseModel.setIdFrom(1l);
        messagesDataBaseModel.setUserNameFrom("Peter");

        messagesDataBaseModel.setIdTo(2l);
        messagesDataBaseModel.setUserNameTo("Helen");

        messagesDataBaseModel.setMessage("Hi");
        MessagesDataBaseModel messagesDataBaseModel1 =
                MessagesDataBaseModel.builder().
                        date(new Date()).
                        idTo(2l).
                        userNameTo("a1").
                        idFrom(5l).
                        userNameFrom("b1").
                        message("AAAA").
                        build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(messagesDataBaseModel1);
        System.out.println(json);

    }
}
