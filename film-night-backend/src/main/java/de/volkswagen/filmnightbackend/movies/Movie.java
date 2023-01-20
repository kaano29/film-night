package de.volkswagen.filmnightbackend.movies;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

    private int rank;
    private String title;
    private String rating;
    private String image;
    private String description;
    private String genre;
    private String imdbid;
}
