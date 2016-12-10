package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "tags", schema = "epamproject")
public class TagsEntity {
    private int idTags;
    private int idQuestion;
    private String tag;

    @Id
    @Column(name = "id_tags", nullable = false)
    public int getIdTags() {
        return idTags;
    }

    public void setIdTags(int idTags) {
        this.idTags = idTags;
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
    @Column(name = "tag", nullable = false, length = 45)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagsEntity that = (TagsEntity) o;

        if (idTags != that.idTags) return false;
        if (idQuestion != that.idQuestion) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTags;
        result = 31 * result + idQuestion;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
