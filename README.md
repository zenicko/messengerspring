# The application SimpleMessenger
The SimpleMessenger is an application which creating by Framework Spring. 

## The requirements
The application is included the base functions:
* регистрация нового пользователя (возвращается уникальный ID);
* поиск по Ф.И.О. (возвращается уникальный ID);
* отправка сообщения по выбранному ID;
* сохранение отправленных сообщений;
* получение сообщения по ID.

### The list of fields of Users database is
- `id` - Unique field (long, NoNULL);
- `fio` - first and last names (string, NoNULL);
- `password` - the password of a user (string, NoNULL). 

### The list of fields of Messages database is
- `time` - the time sending a message;
- `id_from` - the `id` of a user which to send a message (long, NoNULL);
- `fio_from` - the `fio` of a user which to send a message (String, NoNULL);
- `id_to` - the `id` of a user which to get a message (long, NoNULL);
- `fio_to` - the `fio` of a user which to get a message (String, NoNULL).
- `text` - the text of message (String, NoNULL).

### How to save data
The application uses a simple path to save data - 
there is a csv file for each database. See here `scr/resource/database`.

### The models
#### LoginInfo
`fio`, `password`
#### UserID
`id`

### The configs [2]
The file project.properties is to `src/main/resources/configs/project/project.properties`.
See the example `src/main/resources/configs/project/project.properties.example`
#### The file project.properties
project.Path.usersDataBase - the path to users database

project.Path.messagesDataBase - the path to users database



## Resources
1. [Reading a CSV File into an Array](https://www.baeldung.com/java-csv-file-array)
2. [Basic usage](http://owner.aeonbits.org/docs/usage/)
3. [Introduction to OpenCSV](https://www.baeldung.com/opencsv)
4. [Ломбок @Builder с наследованием](https://javascopes.com/lombok-builder-inheritance-bce31ecd/)
5. [Convert String to Date in Java](https://www.baeldung.com/java-string-to-date)
6. [SimpleDateFormat.java](java/text/SimpleDateFormat.java)
7. []()
8. []()
9. []()
10. []()
11. []()
12. []()
13. []()
