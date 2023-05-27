package com.example.project4.Service;

import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Director;
import com.example.project4.Model.Movie;
import com.example.project4.Repository.DirectorRepository;
import com.example.project4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        Director d = directorRepository.getDirectorById(movie.getDirectorID());
        if (d == null)
            throw new ApiException("Director not found");
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie){
        Movie m = movieRepository.getMovieById(id);
        if (m == null)
            throw new ApiException("Not found");
        m.setName(movie.getName());
        m.setGenre(movie.getGenre());
        m.setRating(movie.getRating());
        m.setDuration(movie.getDuration());
        m.setDirectorID(movie.getDirectorID());
        movieRepository.save(m);
    }

    public void deleteMovie(Integer id){
        Movie m = movieRepository.getMovieById(id);
        if (m == null)
            throw new ApiException("Not found");
        movieRepository.delete(m);
    }

    public Movie getMovieByTitle(String name){
        return movieRepository.getMovieByName(name);
    }

    public Integer getDurationOfMovieName(String name){
        return movieRepository.getDurationOfMovieName(name);
    }

    public String getDirectorNameByMovieName(String name){
        Integer id = movieRepository.getDirectorByMovieName(name);
        Director d = directorRepository.getDirectorById(id);
        return d.getName();
    }

    public List<Movie> getMoviesByDirectorID(Integer director){
        return movieRepository.getMoviesByDirectorID(director);
    }

    public Double getRateOfMovie(String name){
        return movieRepository.getRateOfMovie(name);
    }

    public List<Movie> getMoviesByRating(Double rate){
        return movieRepository.getMoviesByRating(rate);
    }

    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.getMoviesByGenre(genre);
    }
}
