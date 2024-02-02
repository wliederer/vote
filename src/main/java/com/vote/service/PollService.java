package com.vote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.model.Poll;
import com.vote.repository.PollRepository;

@Service
public class PollService {
	@Autowired
	private PollRepository pollRepository;
	
//	public PollService(PollRepository pollRepository) {
//		this.pollRepository = pollRepository;
//	}
	
	public Poll createPoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public List<Poll> getAll() {
		return pollRepository.findAll();
	}
	
	public Poll updatePoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public Optional<Poll> findById(String id) {
		return pollRepository.findById(id);
	}

}
