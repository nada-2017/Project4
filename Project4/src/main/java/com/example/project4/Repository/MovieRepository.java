package com.example.project4.Repository;

import com.example.project4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("select m from Movie m where m.id = ?1")
    Movie getMovieById(Integer id);

    @Query("select m from Movie m where m.name = ?1")
    Movie getMovieByName(String name);

    @Query("select m.duration from Movie m where m.name = ?1")
    Integer getDurationOfMovieName(String name);

    @Query("select m.directorID from Movie m where m.name = ?1")
    Integer getDirectorByMovieName(String name);

    @Query("select m from Movie m where m.directorID = ?1")
    List<Movie> getMoviesByDirectorID(Integer director);

    @Query("select m.rating from Movie m where m.name = ?1")
    Double getRateOfMovie(String name);

    @Query("select m from Movie m where m.rating > ?1")
    List<Movie> getMoviesByRating(Double rate);

    @Query("select m from Movie m where m.genre = ?1")
    List<Movie> getMoviesByGenre(String genre);
}
