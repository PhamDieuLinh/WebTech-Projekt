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
    @Column(name = "rating")
    private  Rating rating;
    @Column(name = "rid")
    private Long rid;

    public BewertungEntity(String authorName, String review, Rating rating,  Long rid) {
        this.id = id;
        this.authorName = authorName;
        this.review = review;
        this.rating = rating;
        this.rid = rid;
    }

    protected BewertungEntity(){

    }

    public Long getId() {
        return id;
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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Long getRid() {
        return rid;
    }
    public void setRid(Long rid) {
        this.rid = rid;
    }
}
