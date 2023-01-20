package de.volkswagen.filmnightbackend.filmevent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmEventService {

    private final FilmEventRepository filmEventRepository;

    public FilmEventService(FilmEventRepository filmEventRepository) {
        this.filmEventRepository = filmEventRepository;
    }

    public Optional<List<FilmEventEntity>> getFilmEventsForUser(Long userId) {
        List<FilmEventEntity> filmEventEntityList = this.filmEventRepository.findAll();
        List<FilmEventEntity> filteredList = filmEventEntityList.stream()
                .filter(filmEvent -> {
                    for (Long key : filmEvent.getUserVote().keySet()) {
                        if (key.equals(userId)) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return Optional.of(filteredList);
    }

    public FilmEventEntity createFilmEvent(FilmEventEntity filmEvent) {
        if (filmEvent.getId() != null && this.filmEventRepository.findById(filmEvent.getId()).isPresent()) {
            throw new InvalidFilmEventException();
        }
        return this.filmEventRepository.save(filmEvent);
    }

    public FilmEventEntity updateFilmEvent(FilmEventEntity filmEvent) {
        Optional<FilmEventEntity> oFilmEvent = this.filmEventRepository.findById(filmEvent.getId());
        if (oFilmEvent.isPresent()) {
            return this.filmEventRepository.save(filmEvent);
        }
        throw new FilmEventNotFoundException();
    }
}
