package de.volkswagen.filmnightbackend.movies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    @PostConstruct
    @Scheduled(cron = "0 0 0 ? * MON") // run every Monday at 12:00 am
    public void fetchData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "483a2455f2msh955c5e2e4878255p11ecc3jsn38c82a34ab9f");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://imdb-top-100-movies.p.rapidapi.com/",
                HttpMethod.GET,
                entity,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        List<Movie> movieList = new LinkedList<>();
        List<Object> fetchedList = null;
        try {
            fetchedList = mapper.readValue(response.getBody(), List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (Object movie : fetchedList) {
            HashMap<String, Object> map = (HashMap<String, Object>) movie;
            Movie newMovie = Movie.builder()
                    .rank((Integer) map.get("rank"))
                    .title(String.valueOf(map.get("title")))
                    .rating(String.valueOf(map.get("rating")))
                    .image(String.valueOf(map.get("image")))
                    .description(String.valueOf(map.get("description")))
                    .genre(String.valueOf(map.get("genre")))
                    .imdbid(String.valueOf(map.get("imdbid")))
                    .build();

            movieList.add(newMovie);
        }
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}