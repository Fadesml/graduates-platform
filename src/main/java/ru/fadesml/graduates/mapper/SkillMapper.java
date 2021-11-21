package ru.fadesml.graduates.mapper;

import org.mapstruct.Mapper;
import ru.fadesml.graduates.domain.entity.Skill;
import ru.fadesml.graduates.payload.admin.SkillDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(SkillDto dto);

    List<Skill> toEntity(List<SkillDto> dtos);

    SkillDto toDto(Skill entity);
    List<SkillDto> toDto(List<Skill> entities);
}
