package ru.zenicko.messengerspring.databases;

import com.opencsv.*;
import org.aeonbits.owner.ConfigFactory;
import ru.zenicko.messengerspring.config.project.ProjectConfig;
import ru.zenicko.messengerspring.domain.databases.MessagesDataBaseModel;
import ru.zenicko.messengerspring.domain.response.Messages;
import ru.zenicko.messengerspring.domain.response.UserID;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    /**
     * The method return the list of messages or null.
     *
     * @param userId
     * @return
     * @author Zenicko
     */
    public Messages getMessages(UserID userId) throws Exception {
        Messages messages = new Messages();
        List<String[]> rows = readAllRows();

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d H:m:s z y", Locale.ENGLISH);

        if (rows == null || rows.isEmpty()) return null;

        for (String[] row : rows) {
            if (row[1].equals(String.valueOf(userId.getId()))) {
                MessagesDataBaseModel message = new MessagesDataBaseModel();
                message.setDate(formatter.parse(row[0]));

                message.setIdFrom(Long.parseLong(row[1]));
                message.setUserNameFrom(row[2]);

                message.setIdTo(Long.parseLong(row[3]));
                message.setUserNameTo(row[4]);

                message.setMessage(row[5]);

                messages.add(message);
            }
        }
        return messages;
    }

    private List<String[]> readAllRows() throws Exception {
        Reader reader = new FileReader(pathMessagesDataBase);
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                //        .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        List<String[]> list = new ArrayList<String[]>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}
