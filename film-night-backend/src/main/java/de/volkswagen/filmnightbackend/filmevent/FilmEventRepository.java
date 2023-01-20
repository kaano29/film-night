package de.volkswagen.filmnightbackend.filmevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmEventRepository extends JpaRepository<FilmEventEntity, Long> {
}

