package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 3)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2)
    @Column(columnDefinition = "varchar(20) check ( length(name) > 2 )")
    private String name;

    //@OneToOne(mappedBy = "directorID")
    //private Movie movie;
}
