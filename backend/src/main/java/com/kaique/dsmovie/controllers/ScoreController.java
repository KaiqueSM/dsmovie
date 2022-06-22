package com.kaique.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.dsmovie.dto.MovieDTO;
import com.kaique.dsmovie.dto.ScoreDTO;
import com.kaique.dsmovie.services.ScoreService;

@RestController 
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	ScoreService service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		return service.SaveScore(dto)	;
	}
}
