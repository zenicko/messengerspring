package ru.zenicko.messengerspring.config.project;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configs/project/project.properties"})
public interface ProjectConfig extends Config {

    @Key("project.path.usersDataBase")
    public String pathUsersDataBase();

    @Key("project.path.messagesDataBase")
    public String pathMessagesDataBase();

}
