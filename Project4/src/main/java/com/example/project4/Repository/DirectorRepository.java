package com.example.project4.Repository;

import com.example.project4.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorRepository extends JpaRepository<Director,Integer> {

    @Query("select d from Director d where d.id = ?1")
    Director getDirectorById(Integer id);
}
