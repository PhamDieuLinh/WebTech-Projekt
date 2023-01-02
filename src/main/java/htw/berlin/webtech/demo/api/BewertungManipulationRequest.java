package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.persistence.Rating;

public class BewertungManipulationRequest {

    private String authorName;
    private String review;
    private Rating rating;
    private long rid;


    public BewertungManipulationRequest(String authorName, String review, Rating rating, long rid) {
        this.authorName = authorName;
        this.review = review;
        this.rating = rating;
        this.rid = rid;
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

    public long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}
