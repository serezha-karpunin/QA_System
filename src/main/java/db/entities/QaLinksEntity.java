package db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by n on 10.12.2016.
 */
@Entity
@Table(name = "qa_links", schema = "epamproject", catalog = "")
public class QaLinksEntity {
    private int idQaLinks;

    @Id
    @Column(name = "id_qa_links", nullable = false)
    public int getIdQaLinks() {
        return idQaLinks;
    }

    public void setIdQaLinks(int idQaLinks) {
        this.idQaLinks = idQaLinks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaLinksEntity that = (QaLinksEntity) o;

        if (idQaLinks != that.idQaLinks) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idQaLinks;
    }
}
