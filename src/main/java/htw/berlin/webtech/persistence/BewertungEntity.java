package htw.berlin.webtech.persistence;

import javax.persistence.*;
import java.util.List;

@Entity(name = "bewertung")
public class BewertungEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String authorName;
    @Column(name = "review")
    private String review;

    @Column(name = "kategorie")
    @Enumerated(value = EnumType.ORDINAL)
    private Kategorie kategorie;

    public BewertungEntity(Long id, String authorName, String review, Kategorie kategorie) {
        this.id = id;
        this.authorName = authorName;
        this.review = review;
        this.kategorie = kategorie;
    }

    protected BewertungEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
}
