package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.GraduateChampion;

import java.util.List;

public interface GraduateChampionRepository extends JpaRepository<GraduateChampion, Long> {
    List<GraduateChampion> findAllByGraduate_Name(String name);
}
