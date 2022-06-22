package com.kaique.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
