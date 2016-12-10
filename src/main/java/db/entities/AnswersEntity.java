package db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by n on 10.12.2016.
 */
@Entity
@Table(name = "answers", schema = "epamproject")
public class AnswersEntity {
    private int idAnswer;
    private String textAnswer;
    private Timestamp dateAnswer;
    private String login;

    @Id
    @Column(name = "id_answer", nullable = false)
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Basic
    @Column(name = "text_answer", nullable = false, length = 15)
    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    @Basic
    @Column(name = "date_answer", nullable = false)
    public Timestamp getDateAnswer() {
        return dateAnswer;
    }

    public void setDateAnswer(Timestamp dateAnswer) {
        this.dateAnswer = dateAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswersEntity that = (AnswersEntity) o;

        if (idAnswer != that.idAnswer) return false;
        if (textAnswer != null ? !textAnswer.equals(that.textAnswer) : that.textAnswer != null) return false;
        if (dateAnswer != null ? !dateAnswer.equals(that.dateAnswer) : that.dateAnswer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnswer;
        result = 31 * result + (textAnswer != null ? textAnswer.hashCode() : 0);
        result = 31 * result + (dateAnswer != null ? dateAnswer.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 15)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
