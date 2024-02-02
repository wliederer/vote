package com.vote.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("polls")
public class Poll {
	
	@Id
	private String id;
	private String question;
	private ArrayList<Pick> picks;
	

}
