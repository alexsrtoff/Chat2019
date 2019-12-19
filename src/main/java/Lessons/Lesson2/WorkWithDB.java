package Lessons.Lesson2;

import java.sql.*;

public class WorkWithDB {
    public static void main(String[] args) {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            /*Создаем таблицу*/
            int result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, score INTEGER NOT NULL);");

            /*добавляем столбцы*/
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students (name, score) VALUES ( ?, ?);");
            for (int i = 0; i < 5; i++) {
                ps.setString(1, "Bob " + i);
                ps.setInt(2, 20 + i*2);
                ps.executeUpdate();

            }
            connection.setAutoCommit(true);

            /*меняем значение в столбце*/
            result = stmt.executeUpdate("UPDATE students set score = '100' where  id = 3");

            /*запрашиваем значения по параметрам*/
            ResultSet rs = stmt.executeQuery("select id, name, score from students where score = 100");
            while (rs.next()){
                System.out.print("id: " + rs.getInt(1) + ", ");
                System.out.println("name: " + rs.getString("name"));
            }

            /*удаляем данные из таблицы*/
            result = stmt.executeUpdate("delete from students");

            /*удалаем таблицу*/
            result = stmt.executeUpdate("drop table IF EXISTS students");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }


    }
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Lesson2DB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
