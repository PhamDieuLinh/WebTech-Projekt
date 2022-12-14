package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.persistence.Rating;

public class Bewertung {

    private Long id;
    private String authorName;
    private String review;
    private int rating;
    private Long rid;

    public Bewertung(Long id, String authorName, String review, int rating, Long rid) {
        this.id = id;
        this.authorName = authorName;
        this.review = review;
        this.rating = rating;
        this.rid = rid;
    }

    public long getId() {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }
}
