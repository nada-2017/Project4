package com.example.project4.Controller;

import com.example.project4.Model.Movie;
import com.example.project4.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id,@Valid@RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }

    @GetMapping("/get-movie/{name}")
    public ResponseEntity getMovieByTitle(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getMovieByTitle(name));
    }

    @GetMapping("/get-duration/{name}")
    public ResponseEntity getDurationOfMovieName(@PathVariable String name){
        Integer duration = movieService.getDurationOfMovieName(name);
        return ResponseEntity.status(200).body("The duration of the movie: " + duration);
    }

    @GetMapping("/get-director/{name}")
    public ResponseEntity getDirectorNameByMovieName(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDirectorNameByMovieName(name));
    }

    @GetMapping("/get-movies/{director}")
    public ResponseEntity getMoviesByDirectorID(@PathVariable Integer director){
        return ResponseEntity.status(200).body(movieService.getMoviesByDirectorID(director));
    }

    @GetMapping("/get-rate/{name}")
    public ResponseEntity getRateOfMovie(@PathVariable String name){
        return ResponseEntity.status(200).body("The rate: "+movieService.getRateOfMovie(name));
    }

    @GetMapping("/get-movies-rate/{rate}")
    public ResponseEntity getMoviesByRating(@PathVariable Double rate){
        return ResponseEntity.status(200).body(movieService.getMoviesByRating(rate));
    }

    @GetMapping("get-movies-genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(genre));
    }
}
