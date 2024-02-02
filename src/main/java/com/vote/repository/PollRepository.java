package com.vote.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vote.model.Poll;

public interface PollRepository extends MongoRepository<Poll,String> {

}
