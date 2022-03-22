package ru.zenicko.messengerspring.databases;

import com.opencsv.*;
import org.aeonbits.owner.ConfigFactory;
import ru.zenicko.messengerspring.config.project.ProjectConfig;
import ru.zenicko.messengerspring.domain.databases.UsersDataBaseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDataBase {
    ProjectConfig projectConfig;
    String pathUsersDataBase;
    private long _ID = 1;

    public UsersDataBase() throws Exception {
        projectConfig = ConfigFactory.create(ProjectConfig.class);
        pathUsersDataBase = projectConfig.pathUsersDataBase();

        File file = new File(pathUsersDataBase);
        // Check a file of Message database is existed and if it needs to create

        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (file.isFile()) {
            List<String[]> list = readAllRows();
            if (!list.isEmpty()) {
                long max = list.stream().map(el -> el[0]).mapToLong(Long::valueOf).max().getAsLong();
                _ID = max + 1;
            }
        }

    }

    public long getID() {
        return _ID;
    }

    public boolean IsExistID(long id) throws Exception {
        String userName = getUserName(id);
        if (userName == null) return false;
        if (userName.equals("")) return false;

        return true;
    }

    public String getUserName(long id) throws Exception {
        List<String[]> list = readAllRows();
        if (list.isEmpty()) return null;

        for (String[] line : list) {
            if (line[0].equals(String.valueOf(id))) return line[0];

        }
        return "";
    }

    private boolean csvWriterLine(String[] row, String path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path, true));
        writer.writeNext(row);
        writer.close();
        _ID++;

        return true;
    }

    /***
     * Inside voice: It's a stoooopid code!
     * Me: I promise to refactoring it :)
     * @param usersDataBaseModel the object of class UsersDataBaseModel
     * @return
     */
    private String[] convertModelToStringArray(UsersDataBaseModel usersDataBaseModel) {
        String[] row = new String[3];

        row[0] = String.valueOf(usersDataBaseModel.getId());
        row[1] = usersDataBaseModel.getUsername();
        row[2] = usersDataBaseModel.getPassword();

        return row;
    }

    public boolean insert(UsersDataBaseModel usersDataBaseModel) throws Exception {
        if (usersDataBaseModel == null) return false;
        if (IsExistID(usersDataBaseModel.getId())) return false;

        return csvWriterLine(convertModelToStringArray(usersDataBaseModel), pathUsersDataBase);
    }

    private List<String[]> readAllRows() throws Exception {
        Reader reader = new FileReader(pathUsersDataBase);
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
