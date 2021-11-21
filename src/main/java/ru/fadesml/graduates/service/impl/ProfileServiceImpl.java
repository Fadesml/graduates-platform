package ru.fadesml.graduates.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.fadesml.graduates.domain.entity.Graduate;
import ru.fadesml.graduates.domain.entity.GraduateChampion;
import ru.fadesml.graduates.domain.entity.GraduateSkill;
import ru.fadesml.graduates.domain.persistence.ChampionRepository;
import ru.fadesml.graduates.domain.persistence.GraduateChampionRepository;
import ru.fadesml.graduates.domain.persistence.GraduateRepository;
import ru.fadesml.graduates.domain.persistence.GraduateSkillRepository;
import ru.fadesml.graduates.domain.persistence.SkillRepository;
import ru.fadesml.graduates.exception.NotFoundException;
import ru.fadesml.graduates.payload.GraduateShortPreview;
import ru.fadesml.graduates.payload.profile.GraduateChampionProfile;
import ru.fadesml.graduates.payload.profile.GraduateProfile;
import ru.fadesml.graduates.payload.profile.GraduateSkillProfile;
import ru.fadesml.graduates.service.ProfileService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ProfileServiceImpl implements ProfileService {
    private final ChampionRepository championRepository;
    private final GraduateChampionRepository graduateChampionRepository;
    private final GraduateRepository graduateRepository;
    private final GraduateSkillRepository graduateSkillRepository;
    private final SkillRepository skillRepository;

    @Override
    public GraduateProfile getProfile(String name) {
        Graduate graduate = graduateRepository.findById(name)
                .orElseThrow(() -> new NotFoundException("Graduate with name: " + name + ", not found!"));

        List<GraduateSkill> skills = graduateSkillRepository.findAllByGraduate_Name(name);
        List<GraduateChampion> champions = graduateChampionRepository.findAllByGraduate_Name(name);

        return new GraduateProfile(
                graduate,
                champions.stream()
                        .map(GraduateChampionProfile::new)
                        .collect(Collectors.toList()),
                skills.stream()
                        .map(GraduateSkillProfile::new)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<GraduateShortPreview> getGraduatesShortPreview(int page, int size, String preGraduateName) {
        List<Graduate> graduates = graduateRepository.findAll(PageRequest.of(page, size)).toList();
        if (preGraduateName != null) {
            graduates = graduates.stream()
                    .filter(item -> item.getName().trim().toLowerCase()
                            .contains(preGraduateName.trim().toLowerCase())
                    ).collect(Collectors.toList());
        }

        return graduates.stream()
                .map(item ->
                new GraduateShortPreview(item,
                        graduateChampionRepository.findAllByGraduate_Name(
                                item.getName()).stream().map(gc -> gc.getChampion().getName()).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
