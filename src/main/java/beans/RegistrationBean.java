package beans;

import db.entities.UsersEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Locale;

public class RegistrationBean implements Serializable {
    private String login;
    private String email;
    private String password;

    public RegistrationBean() {

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
        entity.setEmail(email);
        entity.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        entity.setLang(Locale.getDefault().getLanguage());
        return entity;
    }
}
