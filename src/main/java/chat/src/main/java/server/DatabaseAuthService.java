package server;

import java.sql.*;

public class DatabaseAuthService implements AuthService {
    private Connection conn;
    private Statement stmt;

    public DatabaseAuthService(String fileName) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            stmt = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS users (");
            sb.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append("login TEXT, ");
            sb.append("pass TEXT, ");
            sb.append("nick TEXT);");

            stmt.executeUpdate(sb.toString());
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    public String getNickByLoginPass(String login, String pass) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM users ");
            sb.append("WHERE login = '");
            sb.append(login);
            sb.append("' AND pass = '");
            sb.append(pass);
            sb.append("';");

            ResultSet result = stmt.executeQuery(sb.toString());
            if (result.next()) {
                return result.getString(3);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }

        return null;
    }

    public void addNewUser(String login, String pass, String nick) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO users (login, pass, nick) ");
            sb.append("VALUES ('");
            sb.append(login);
            sb.append("', '");
            sb.append(pass);
            sb.append("', '");
            sb.append(nick);
            sb.append("');");

            stmt.executeUpdate(sb.toString());
        }
        catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
