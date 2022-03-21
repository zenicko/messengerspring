package ru.zenicko.messengerspring.databases;

import com.opencsv.*;
import org.aeonbits.owner.ConfigFactory;
import ru.zenicko.messengerspring.config.project.ProjectConfig;
import ru.zenicko.messengerspring.domain.databases.UsersDataBaseModel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UsersDataBase {
    ProjectConfig projectConfig;
    String pathUsersDataBase;
    private long _ID = 1;

    public UsersDataBase() {
        projectConfig = ConfigFactory.create(ProjectConfig.class);
        pathUsersDataBase = projectConfig.pathUsersDataBase();
    }

    public long getID() {
        return _ID;
    }

    public boolean IsExistID(long id) throws Exception {
        List<String[]> list = readAllRows();
        if (list.isEmpty()) return false;

        for (String[] line : list) {
            if (line[0].equals(String.valueOf(id))) return true;

        }
        return false;
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
     * @param usersDataBaseModel
     * @return
     */
    private String[] convertModelToStringArray(UsersDataBaseModel usersDataBaseModel) {
        String[] row = new String[3];
        row[0] = String.valueOf(usersDataBaseModel.getId());
        row[1] = usersDataBaseModel.getFio();
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
