package ru.fadesml.graduates.payload.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fadesml.graduates.domain.entity.GraduateSkill;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduateSkillProfile {
    private String name;
    private String description;
    private Integer percent;

    public GraduateSkillProfile(GraduateSkill graduateSkill) {
        this.name = graduateSkill.getSkill().getName();
        this.description = graduateSkill.getSkill().getDescription();
        this.percent = graduateSkill.getPercent();
    }
}
