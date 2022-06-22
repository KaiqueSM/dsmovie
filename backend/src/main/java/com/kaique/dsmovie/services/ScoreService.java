package com.kaique.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.dsmovie.dto.MovieDTO;
import com.kaique.dsmovie.dto.ScoreDTO;
import com.kaique.dsmovie.entities.Movie;
import com.kaique.dsmovie.entities.Score;
import com.kaique.dsmovie.entities.User;
import com.kaique.dsmovie.repositories.MovieRepository;
import com.kaique.dsmovie.repositories.ScoreRepository;
import com.kaique.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO SaveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}	
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get(); 
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()){	
			sum += s.getValue();
		};
		
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDTO(movie);
	}
}
