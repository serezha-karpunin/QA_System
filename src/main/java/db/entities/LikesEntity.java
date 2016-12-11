package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "likes", schema = "epamproject")
public class LikesEntity {
    private int idLikes;
    private int idAnswer;
    private String login;

    @Id
    @Column(name = "id_likes", nullable = false)
    public int getIdLikes() {
        return idLikes;
    }

    public void setIdLikes(int idLikes) {
        this.idLikes = idLikes;
    }

    @Basic
    @Column(name = "id_answer", nullable = false)
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 15)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikesEntity that = (LikesEntity) o;

        if (idLikes != that.idLikes) return false;
        if (idAnswer != that.idAnswer) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLikes;
        result = 31 * result + idAnswer;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}
