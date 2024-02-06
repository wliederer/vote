package com.vote.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vote.model.Poll;
import com.vote.service.PollService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@Validated
public class PollController {
	
	private static final Logger log = LoggerFactory.getLogger(PollController.class);
	
	@Autowired
	private PollService pollService;
	
	@GetMapping("/polls")
	public ResponseEntity<List<Poll>> getAllPolls() {
		List<Poll> polls = pollService.getAll();
		return new ResponseEntity<>(polls,HttpStatus.OK);
	}
	
	@GetMapping("/polls/search")
	public ResponseEntity<List<Poll>> getSearchPolls(@RequestParam("question") String question) {
		List<Poll> polls = pollService.findByQuestion(question);
		return new ResponseEntity<>(polls,HttpStatus.OK);
	}
	
	@GetMapping("/polls/{id}")
	public ResponseEntity<Optional<Poll>> getById(@PathVariable String id){
		Optional<Poll> poll = pollService.findById(id);
		if(poll.isPresent()) {
			return new ResponseEntity<>(poll,HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(poll,HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/polls")
	public ResponseEntity<Poll> createPoll(@Valid @RequestBody Poll poll){
		log.info("Creating Poll ",poll);
		 poll = pollService.createPoll(poll);
		return new ResponseEntity<>(poll,HttpStatus.CREATED);
	}
	
	@PutMapping("/polls/{id}")
	public ResponseEntity<Poll> updatePoll(@PathVariable String id,@RequestBody Poll poll){
		 poll = pollService.updatePoll(poll);
		return new ResponseEntity<>(poll,HttpStatus.OK);
	}

}
