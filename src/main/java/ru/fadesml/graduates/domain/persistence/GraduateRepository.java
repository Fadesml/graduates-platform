package ru.fadesml.graduates.domain.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.graduates.domain.entity.Graduate;

public interface GraduateRepository extends JpaRepository<Graduate, String> {
    Page<Graduate> findAll(Pageable pageable);
}
