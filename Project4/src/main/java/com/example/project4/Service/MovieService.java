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
        Movie m = movieRepository.getMovieByName(name);
        if (m == null)
            throw new ApiException("Not found");
        return m;
    }

    public Integer getDurationOfMovieName(String name){
        Integer d = movieRepository.getDurationOfMovieName(name);
        if (d == 0)
            throw new ApiException("Not found");
        return d;
    }

    public String getDirectorNameByMovieName(String name){
        Integer id = movieRepository.getDirectorByMovieName(name);
        if (id == 0)
            throw new ApiException("Not found");
        Director d = directorRepository.getDirectorById(id);
        return d.getName();
    }

    public List<Movie> getMoviesByDirectorID(Integer director){
        List<Movie> movies = movieRepository.getMoviesByDirectorID(director);
        if (movies.size() == 0)
            throw new ApiException("Not found");
        return movies;
    }

    public Double getRateOfMovie(String name){
        Double d = movieRepository.getRateOfMovie(name);
        if (d == 0)
            throw new ApiException("Not found");
        return d;
    }

    public List<Movie> getMoviesByRating(Double rate){
        List<Movie> movies = movieRepository.getMoviesByRating(rate);
        if (movies.size() == 0)
            throw new ApiException("Not found");
        return movies;
    }

    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.getMoviesByGenre(genre);
        if (movies.size() == 0)
            throw new ApiException("Not found");
        return movies;
    }
}
