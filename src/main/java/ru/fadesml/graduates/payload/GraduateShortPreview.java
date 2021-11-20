package ru.fadesml.graduates.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fadesml.graduates.domain.entity.Plate;
import ru.fadesml.graduates.domain.entity.enums.EDivision;
import ru.fadesml.graduates.domain.entity.enums.ERank;
import ru.fadesml.graduates.domain.entity.enums.ERole;
import ru.fadesml.graduates.domain.entity.enums.EServer;
import ru.fadesml.graduates.domain.entity.Graduate;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduateShortPreview {
    private String name;
    private String fullName;
    private String server;

    //final rank
    private String finalRank;
    private String finalDivision;
    private Integer finalLP;

    private String mainRole;
    private String secondRole;

    private List<String> plates;

    private List<String> champions;

    private String opgg;

    public GraduateShortPreview(Graduate graduate, List<String> champions) {
        this.name = graduate.getName();
        this.fullName = graduate.getFullName();
        this.plates = graduate.getPlates().stream().map(Plate::getName).collect(Collectors.toList());

        this.server = EServer.get(graduate.getServer());
        this.mainRole = ERole.get(graduate.getMainRole());
        this.secondRole = ERole.get(graduate.getSecondRole());
        this.champions = champions;
        this.opgg = graduate.getOpgg();

        this.finalRank = ERank.get(graduate.getFinalRank());
        this.finalDivision = EDivision.get(graduate.getFinalDivision());
        this.finalLP = graduate.getFinalLP();
    }
}
