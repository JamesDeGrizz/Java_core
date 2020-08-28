package server;

public interface AuthService {
    void start();

    String getNickByLoginPass(String login, String pass);

    void addNewUser(String login, String pass, String nick);

    void stop();
}
