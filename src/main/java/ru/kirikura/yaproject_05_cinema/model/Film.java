package ru.kirikura.yaproject_05_cinema.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Film {
    private int id;
    @NotBlank
    private String name;
    @Size(max = 200)
    private String description;
    @NotBlank
    private LocalDate releaseDate;
    @Min(1)
    private long duration;
    private Set<Integer> likes = new HashSet<>();
}
