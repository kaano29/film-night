package de.volkswagen.filmnightbackend.filmevent;

import de.volkswagen.filmnightbackend.enums.Vote;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "film_events")
public class FilmEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime dateTime;

    private String location;

    @ElementCollection
    private Map<Long, Vote> userVote;

    private String genre;

    private boolean favoriteRecommendation;

    private int numberOfMovies;
}
