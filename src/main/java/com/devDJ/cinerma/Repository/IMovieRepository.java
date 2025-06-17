package com.devDJ.cinerma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devDJ.cinerma.Entities.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

}
