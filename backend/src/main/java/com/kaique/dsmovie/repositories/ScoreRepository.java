package com.kaique.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.dsmovie.entities.Score;
import com.kaique.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
