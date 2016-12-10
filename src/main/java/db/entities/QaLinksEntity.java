package db.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by n on 10.12.2016.
 */
@Entity
@Table(name = "qa_links", schema = "epamproject")
public class QaLinksEntity {
    private int idAnswer;
    private int idQuestion;

    @Basic
    @Column(name = "id_answer", nullable = false)
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Basic
    @Column(name = "id_question", nullable = false)
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaLinksEntity that = (QaLinksEntity) o;

        if (idAnswer != that.idAnswer) return false;
        if (idQuestion != that.idQuestion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnswer;
        result = 31 * result + idQuestion;
        return result;
    }
}
