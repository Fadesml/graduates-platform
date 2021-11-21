package ru.fadesml.graduates.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fadesml.graduates.domain.entity.Skill;
import ru.fadesml.graduates.domain.persistence.SkillRepository;
import ru.fadesml.graduates.mapper.SkillMapper;
import ru.fadesml.graduates.payload.admin.SkillDto;
import ru.fadesml.graduates.service.SkillService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
class SkillServiceImpl implements SkillService {
    private final SkillRepository repo;
    private final SkillMapper mapper;

    @Override
    public List<SkillDto> save(List<SkillDto> dtos) {
        List<Skill> preEntities = mapper.toEntity(dtos);

        return mapper.toDto(repo.saveAll(preEntities));
    }

    @Transactional
    @Override
    public List<String> delete(List<String> ids) {
        repo.deleteByNameIn(ids);
        return ids;
    }

    @Override
    public List<SkillDto> get() {
        return mapper.toDto(repo.findAll());
    }
}
