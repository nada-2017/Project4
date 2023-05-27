package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@OneToOne(cascade = CascadeType.ALL)
    //private Director directorID;

    @NotEmpty(message = "Name is required")
    @Size(min = 2)
    @Column(columnDefinition = "varchar(20) check ( length(name) > 2 )")
    private String name;

    @Pattern(regexp = "\\b(?:Drama|Action|Comedy)\\b",message = "Genre Not Valid")
    @Column(columnDefinition = "varchar(20) not null check(genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre;

    @NotNull(message = "Rating is required")
    @Positive
    @Min(value = 1)
    @Max(value = 5)
    //@Column(columnDefinition = "double check ( rating > 1 and rating < 5)")
    private Double rating;

    @NotNull(message = "Duration is required")
    @Positive
    @Min(value = 61)
    //@Column(columnDefinition = "int check ( duration > 60 )")
    private Integer duration;

    @NotNull(message = "Director id is required")
    private Integer directorID;
}
