package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.persistence.Rating;

public class BewertungManipulationRequest {

    private String authorName;
    private String review;
    private String rating;
    private Long rid;


    public BewertungManipulationRequest(String authorName, String review, String rating, Long rid) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}
