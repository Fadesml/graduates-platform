package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.Skill;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, String> {
    void deleteByNameIn(List<String> names);
}
