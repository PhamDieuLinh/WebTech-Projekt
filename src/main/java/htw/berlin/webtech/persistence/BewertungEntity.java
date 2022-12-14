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
    private  int rating;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name= "res_id", referencedColumnName = "id")
    private RestaurantEntity resid;

    public BewertungEntity(String authorName, String review, int rating, RestaurantEntity resid) {
        this.authorName = authorName;
        this.review = review;
        this.rating = rating;
        this.resid = resid;
    }

    public BewertungEntity(){
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public RestaurantEntity getResid() {
        return resid;
    }

    public void setResid(RestaurantEntity resid) {
        this.resid = resid;
    }
}
