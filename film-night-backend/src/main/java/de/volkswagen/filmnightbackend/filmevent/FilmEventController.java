package de.volkswagen.filmnightbackend.filmevent;

import de.volkswagen.filmnightbackend.user.InvalidUserException;
import de.volkswagen.filmnightbackend.user.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/filmEvents")
public class FilmEventController {

    private final FilmEventService filmEventService;

    public FilmEventController(FilmEventService filmEventService) {
        this.filmEventService = filmEventService;
    }

    @GetMapping("/{userId}")
    public Optional<List<FilmEventEntity>> getFilmEventsForUser(@PathVariable Long userId) {
        return filmEventService.getFilmEventsForUser(userId);
    }

    @PostMapping
    public ResponseEntity<FilmEventEntity> createFilmEvent(@RequestBody FilmEventEntity filmEvent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.filmEventService.createFilmEvent(filmEvent));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidFilmEventException(InvalidFilmEventException e) {
    }

    @PutMapping
    public FilmEventEntity updateFilmEvent(@RequestBody FilmEventEntity filmEvent) {
        return filmEventService.updateFilmEvent(filmEvent);
    }

}
