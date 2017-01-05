package beans;

import db.entities.UsersEntity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Locale;
import java.security.SecureRandom;

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

    public UsersEntity toEntity() {
        UsersEntity entity = new UsersEntity();
        SecureRandom secureRandom = new SecureRandom();
        String salt = new String(secureRandom.generateSeed(10));
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            password+=salt;
            md.update(password.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] passHash = md.digest();
        entity.setLogin(login);
        entity.setPassword(new String(passHash));
        entity.setEmail(email);
        entity.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        entity.setLang(Locale.getDefault().getLanguage());
        entity.setSalt(salt);
        entity.setImageLink("/avatar.png");
        return entity;
    }
}
