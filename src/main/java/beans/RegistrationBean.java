package beans;

import db.entities.UsersEntity;

import java.io.Serializable;
import java.sql.Timestamp;

public class RegistrationBean implements Serializable {
    private String login;
    private String email;
    private String password;

    public RegistrationBean(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersEntity toEntity(){
        UsersEntity entity = new UsersEntity();
        entity.setLogin(login);
        entity.setPassword(password);
        entity.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        return entity;
    }
}
