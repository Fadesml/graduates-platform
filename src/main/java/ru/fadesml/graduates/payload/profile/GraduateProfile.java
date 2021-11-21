package ru.fadesml.graduates.payload.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fadesml.graduates.domain.entity.Graduate;
import ru.fadesml.graduates.domain.entity.Plate;
import ru.fadesml.graduates.domain.entity.enums.EDivision;
import ru.fadesml.graduates.domain.entity.enums.ERank;
import ru.fadesml.graduates.domain.entity.enums.ERole;
import ru.fadesml.graduates.domain.entity.enums.EServer;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduateProfile {
    //info
    private String name;
    private String server;
    private String fullName;
    private String email;
    private String country;
    private String studentFeedback;
    private String coachFeedback;
    private String opgg;

    //starting rank
    private String startingRank;
    private String startingDivision;
    private Integer startingLP;

    //final rank
    private String finalRank;
    private String finalDivision;
    private Integer finalLP;

    //roles
    private String mainRole;
    private String secondRole;

    private List<String> plates;
    //champions
    private List<GraduateChampionProfile> champions;

    //skills
    private List<GraduateSkillProfile> skills;

    public GraduateProfile(Graduate graduate, List<GraduateChampionProfile> champions, List<GraduateSkillProfile> skills) {
        this.name = graduate.getName();
        this.server = EServer.get(graduate.getServer());
        this.fullName = graduate.getFullName();
        this.email = graduate.getEmail();
        this.country = graduate.getCountry();
        this.studentFeedback = graduate.getStudentFeedback();
        this.coachFeedback = graduate.getCoachFeedback();
        this.opgg = graduate.getOpgg();
        this.startingRank = ERank.get(graduate.getStartingRank());
        this.startingDivision = EDivision.get(graduate.getStartingDivision());
        this.startingLP = graduate.getStartingLP();
        this.finalRank = ERank.get(graduate.getFinalRank());
        this.finalDivision = EDivision.get(graduate.getFinalDivision());
        this.finalLP = graduate.getFinalLP();
        this.mainRole = ERole.get(graduate.getMainRole());
        this.secondRole = ERole.get(graduate.getSecondRole());
        this.champions = champions;
        this.skills = skills;
        this.plates = graduate.getPlates().stream().map(Plate::getName).collect(Collectors.toList());
    }
}
