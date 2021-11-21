package ru.fadesml.graduates.service;

import ru.fadesml.graduates.payload.admin.SkillDto;

import java.util.List;

public interface SkillService {
    List<SkillDto> save(List<SkillDto> dtos);
    List<String> delete(List<String> ids);
    List<SkillDto> get();
}
