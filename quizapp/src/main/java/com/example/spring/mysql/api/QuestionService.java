package com.example.spring.mysql.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		try {
			return new ResponseEntity<>("success",HttpStatus.CREATED);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

}
