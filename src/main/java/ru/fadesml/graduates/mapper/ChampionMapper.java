package ru.fadesml.graduates.mapper;

import org.mapstruct.Mapper;
import ru.fadesml.graduates.domain.entity.Champion;
import ru.fadesml.graduates.payload.admin.ChampionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChampionMapper {
    Champion toEntity(ChampionDto dto);
    List<Champion> toEntity(List<ChampionDto> dtos);

    ChampionDto toDto(Champion entity);
    List<ChampionDto> toDto(List<Champion> entities);
}
