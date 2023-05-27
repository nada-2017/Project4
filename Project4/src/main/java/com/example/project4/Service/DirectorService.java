package com.example.project4.Service;

import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Director;
import com.example.project4.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director d = directorRepository.getDirectorById(id);
        if (d == null)
            throw new ApiException("Not found");
        d.setName(director.getName());
        directorRepository.save(d);
    }

    public void deleteDirector(Integer id){
        Director d = directorRepository.getDirectorById(id);
        if (d == null)
            throw new ApiException("Not found");
        directorRepository.delete(d);
    }
}
