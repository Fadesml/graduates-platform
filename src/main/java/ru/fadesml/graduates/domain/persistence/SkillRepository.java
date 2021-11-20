package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, String> {
}
