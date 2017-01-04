package db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by n on 04.01.2017.
 */
@Entity
@Table(name = "users", schema = "epamproject", catalog = "")
public class UsersEntity {
    private String login;
    private String email;
    private String password;
    private Timestamp registrationDate;
    private String lang;
    private String salt;
    private String imageLink;

    @Id
    @Column(name = "login", nullable = false, length = 15)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "registration_date", nullable = false)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "lang", nullable = false, length = 15)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Basic
    @Column(name = "salt", nullable = false, length = 10)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "imageLink", nullable = false, length = 100)
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (imageLink != null ? !imageLink.equals(that.imageLink) : that.imageLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (imageLink != null ? imageLink.hashCode() : 0);
        return result;
    }
}
