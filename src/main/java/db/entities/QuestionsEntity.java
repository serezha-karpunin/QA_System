package db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "questions", schema = "epamproject")
public class QuestionsEntity {
    private int idQuestion;
    private String login;
    private String title;
    private String textQuestion;
    private Timestamp dateQuestion;
    private int views;

    @Id
    @Column(name = "id_question", nullable = false)
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 15)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 250)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "text_question", nullable = false, length = 500)
    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    @Basic
    @Column(name = "date_question", nullable = false)
    public Timestamp getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(Timestamp dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    @Basic
    @Column(name = "views", nullable = false)
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsEntity that = (QuestionsEntity) o;

        if (idQuestion != that.idQuestion) return false;
        if (views != that.views) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (textQuestion != null ? !textQuestion.equals(that.textQuestion) : that.textQuestion != null) return false;
        if (dateQuestion != null ? !dateQuestion.equals(that.dateQuestion) : that.dateQuestion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuestion;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (textQuestion != null ? textQuestion.hashCode() : 0);
        result = 31 * result + (dateQuestion != null ? dateQuestion.hashCode() : 0);
        result = 31 * result + views;
        return result;
    }
}
