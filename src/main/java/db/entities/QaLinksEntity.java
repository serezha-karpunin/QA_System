package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "qa_links", schema = "epamproject")
public class QaLinksEntity {
    private int idQaLinks;
    private int idQuestion;
    private int idAnswer;

    @Id
    @Column(name = "id_qa_links", nullable = false)
    public int getIdQaLinks() {
        return idQaLinks;
    }

    public void setIdQaLinks(int idQaLinks) {
        this.idQaLinks = idQaLinks;
    }

    @Basic
    @Column(name = "id_question", nullable = false)
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Basic
    @Column(name = "id_answer", nullable = false)
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaLinksEntity that = (QaLinksEntity) o;

        if (idQaLinks != that.idQaLinks) return false;
        if (idQuestion != that.idQuestion) return false;
        if (idAnswer != that.idAnswer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQaLinks;
        result = 31 * result + idQuestion;
        result = 31 * result + idAnswer;
        return result;
    }
}
