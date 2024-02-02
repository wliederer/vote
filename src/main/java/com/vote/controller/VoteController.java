package com.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vote.model.Poll;
import com.vote.service.PollService;

@RestController
@CrossOrigin(origins="*")
public class VoteController {
	
	@Autowired
	private PollService pollService;
	
	@GetMapping("/polls")
	public ResponseEntity<List<Poll>> getAllPolls() {
		List<Poll> polls = pollService.getAll();
		return new ResponseEntity<>(polls,HttpStatus.OK);
	}
	
	@PostMapping("/poll")
	public ResponseEntity<Poll> createPoll(@RequestBody Poll poll){
		 poll = pollService.createPoll(poll);
		return new ResponseEntity<>(poll,HttpStatus.CREATED);
	}

}
