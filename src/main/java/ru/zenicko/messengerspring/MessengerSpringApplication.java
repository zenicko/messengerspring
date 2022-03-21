package ru.zenicko.messengerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zenicko.messengerspring.databases.UsersDataBase;

@SpringBootApplication
public class MessengerSpringApplication {
    public static UsersDataBase usersDataBase;

    public static void main(String[] args) throws Exception {
        usersDataBase = new UsersDataBase();
        SpringApplication.run(MessengerSpringApplication.class, args);
    }

}
