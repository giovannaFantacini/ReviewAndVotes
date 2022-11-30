package com.ReviewAndVotes.ReviewAndVotes.RabbitMQ;

import com.ReviewAndVotes.ReviewAndVotes.model.RAndV;
import com.ReviewAndVotes.ReviewAndVotes.model.Vote;
import com.ReviewAndVotes.ReviewAndVotes.repositories.RAndVRepository;
import com.ReviewAndVotes.ReviewAndVotes.service.RAndVService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @Autowired
    private RAndVService service;

    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void consumeJsonMessage(String vote) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Vote vt = objectMapper.readValue(vote, Vote.class);
        service.AddVote(vt);
        System.out.println("Updating Votes by Review: " + vt.getReviewId());
    }

}
