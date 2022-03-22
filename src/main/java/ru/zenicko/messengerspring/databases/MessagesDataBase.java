package ru.zenicko.messengerspring.databases;

import com.opencsv.CSVWriter;
import org.aeonbits.owner.ConfigFactory;
import ru.zenicko.messengerspring.config.project.ProjectConfig;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MessagesDataBase {
    UsersDataBase usersDataBase;
    ProjectConfig projectConfig;
    String pathMessagesDataBase;

    public MessagesDataBase(UsersDataBase usersDataBase) {
        this.usersDataBase = usersDataBase;
        projectConfig = ConfigFactory.create(ProjectConfig.class);
        pathMessagesDataBase = projectConfig.pathMessagesDataBase();

        // Check a file of Message database is existed and if it needs to create

        File file = new File(pathMessagesDataBase);
        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String[] fromModelToList(MessagesDataBaseModel messagesDataBaseModel) {
        String[] row = new String[6];

        row[0] = String.valueOf(messagesDataBaseModel.getDate());
        row[1] = String.valueOf(messagesDataBaseModel.getIdFrom());
        row[2] = messagesDataBaseModel.getUserNameFrom();
        row[3] = String.valueOf(messagesDataBaseModel.getIdTo());
        row[4] = messagesDataBaseModel.getUserNameTo();
        row[5] = messagesDataBaseModel.getMessage();

        return row;

    }
    private boolean csvWriterLine(String[] row, String path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path, true));
        writer.writeNext(row);
        writer.close();

        return true;
    }

    public boolean insert(MessagesDataBaseModel messagesDataBaseModel) throws Exception {
        if (messagesDataBaseModel == null) return false;
        if (!usersDataBase.IsExistID(messagesDataBaseModel.getIdFrom())) return false;
        if (!usersDataBase.IsExistID(messagesDataBaseModel.getIdTo())) return false;

        return csvWriterLine(fromModelToList(messagesDataBaseModel), pathMessagesDataBase);
    }

}
