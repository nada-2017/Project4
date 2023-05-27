package com.example.project4.Controller;

import com.example.project4.Model.Director;
import com.example.project4.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirectors(){
        return ResponseEntity.status(200).body(directorService.getDirectors());
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid@RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @Valid@RequestBody Director director){
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted");
    }
}
