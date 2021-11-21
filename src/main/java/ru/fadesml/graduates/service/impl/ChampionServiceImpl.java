package ru.fadesml.graduates.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fadesml.graduates.domain.entity.Champion;
import ru.fadesml.graduates.domain.persistence.ChampionRepository;
import ru.fadesml.graduates.mapper.ChampionMapper;
import ru.fadesml.graduates.payload.admin.ChampionDto;
import ru.fadesml.graduates.service.ChampionService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChampionServiceImpl implements ChampionService {
    private final ChampionRepository repo;
    private final ChampionMapper mapper;

    @Override
    public List<ChampionDto> save(List<ChampionDto> dtos) {
        return mapper.toDto(repo.saveAll(mapper.toEntity(dtos)));
    }

    @Transactional
    @Override
    public List<String> delete(List<String> ids) {
        repo.deleteByNameIn(ids);
        return ids;
    }

    @Override
    public List<ChampionDto> get() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public List<ChampionDto> get(String name) {
        return mapper.toDto(
                repo.findAll()
                        .stream()
                        .filter(item -> item.getName()
                                .trim()
                                .toLowerCase()
                                .contains(name
                                        .trim()
                                        .toLowerCase()
                                )
                        ).collect(Collectors.toList()
                ));
    }
}
