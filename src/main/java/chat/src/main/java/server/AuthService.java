package server;

public interface AuthService {
    void start();

    String getNickByLoginPass(String login, String pass);

    void addNewUser(String login, String pass, String nick);

    void changeNickname(String currentNick, String newNick);

    void stop();
}
