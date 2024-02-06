package com.vote.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vote.model.Poll;

public interface PollRepository extends MongoRepository<Poll,String> {
	
	Optional<Poll> findById(String id);
	
	List<Poll> findByQuestionIgnoreCase(String question);

}
