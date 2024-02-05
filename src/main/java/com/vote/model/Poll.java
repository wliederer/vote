package com.vote.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Document("polls")
public class Poll {
	
	@Id
	private String _id;
	@NotBlank(message="Question is required")
	private String question;
	@NotEmpty(message="Picks can not be empty")
	private ArrayList<Pick> picks;
	

}
