package model;

public class User {
    public String login;
    public String psw;
    public String role;
    public String token;
    public int nb;

    public User(String login, String psw, String role, String token, int nb) {
        this.login = login;
        this.psw = psw;
        this.role = role;
        this.token = token;
        this.nb = nb;
    }

    public User() {}
}