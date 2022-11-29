package com.ReviewAndVotes.ReviewAndVotes.repositories;

import com.ReviewAndVotes.ReviewAndVotes.model.RAndV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface RAndVRepository extends JpaRepository<RAndV, String> {

    @Query("SELECT r.numVote FROM RAndV r WHERE r.reviewId = :reviewId")
    int getTotalVotesByReview(@Param("reviewId") String reviewId);

    @Query("SELECT r FROM RAndV r WHERE r.reviewId = :reviewId")
    RAndV findReview(@Param("reviewId") String reviewId);

}
