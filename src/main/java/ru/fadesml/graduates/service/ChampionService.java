package ru.fadesml.graduates.service;

import ru.fadesml.graduates.payload.admin.ChampionDto;

import java.util.List;

public interface ChampionService {
    List<ChampionDto> save(List<ChampionDto> dtos);
    List<String> delete(List<String> ids);
    List<ChampionDto> get();
    List<ChampionDto> get(String name);
}
