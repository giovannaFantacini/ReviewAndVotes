package com.ReviewAndVotes.ReviewAndVotes.controller;

import com.ReviewAndVotes.ReviewAndVotes.service.RAndVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/getTotalVotesByReview")
public class RAndVController {
    @Autowired
    private RAndVService service;

    @GetMapping(value = "/{reviewId}")
    public int getTotalVotesByReview(@PathVariable("reviewId") final String reviewId ){
        return service.getTotalVotesByReview(reviewId);
    }

}
