package com.ReviewAndVotes.ReviewAndVotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "voteByReview")
public class RAndV {

    @Column
    private String reviewId;

    @Column
    private int numVote;

    @Id

    @Column(name = "ID", nullable = false, length = 36)
    private String id;

    public RAndV() {
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String uuidReview) {
        this.reviewId = uuidReview;
    }

    public int getNumVote() {
        return numVote;
    }

    public void setNumVote(int numVote) {
        this.numVote = numVote;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public RAndV(String reviewId, int vote) {
        this.reviewId = reviewId;
        this.numVote = vote;
        UUID Uuid = UUID.randomUUID();
        String id = Uuid.toString();
        this.id = id;
    }

}
