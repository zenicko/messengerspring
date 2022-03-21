package ru.zenicko.messengerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zenicko.messengerspring.databases.UsersDataBase;

@SpringBootApplication
public class MessengerSpringApplication {
	public static UsersDataBase usersDataBase = new UsersDataBase();

	public static void main(String[] args) {


		SpringApplication.run(MessengerSpringApplication.class, args);
	}

}
