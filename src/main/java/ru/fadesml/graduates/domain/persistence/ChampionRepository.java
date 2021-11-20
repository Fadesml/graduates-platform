package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.Champion;

public interface ChampionRepository extends JpaRepository<Champion, String> {
}
