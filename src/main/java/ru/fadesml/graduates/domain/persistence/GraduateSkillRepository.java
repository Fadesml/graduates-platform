package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.GraduateSkill;

import java.util.List;

public interface GraduateSkillRepository extends JpaRepository<GraduateSkill, Long> {
    List<GraduateSkill> findAllByGraduate_Name(String name);
}
