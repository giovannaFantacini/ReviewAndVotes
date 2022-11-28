package com.ReviewAndVotes.ReviewAndVotes.service;

import com.ReviewAndVotes.ReviewAndVotes.model.RAndV;
import com.ReviewAndVotes.ReviewAndVotes.model.Vote;
import com.ReviewAndVotes.ReviewAndVotes.repositories.RAndVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class RAndVService {
    @Autowired
    private RAndVRepository repository;

    public int getTotalVotesByReview(String reviewId) {
        return repository.getTotalVotesByReview(reviewId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found"));
    }

    public void AddVote(Vote vote) {
        String reviewId = vote.getReviewId();
        if(vote.isVote()){
            RAndV rAndV = repository.findReview(reviewId);;
            if(rAndV == null){
                rAndV = new RAndV(reviewId, 1);
            }else{
                int numVote = rAndV.getNumVote();
                rAndV.setNumVote(numVote+1);
            }
            repository.save(rAndV);
        }
    }
}
