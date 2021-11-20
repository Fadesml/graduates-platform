package ru.fadesml.graduates.payload.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fadesml.graduates.domain.entity.GraduateChampion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduateChampionProfile {
    private String name;
    private String averageKDA;
    private String averageCS;
    private String averageCSPerMinute;
    private Integer summaryGames;

    public GraduateChampionProfile(GraduateChampion graduateChampion) {
        this.name = graduateChampion.getChampion().getName();
        this.averageKDA = graduateChampion.getAverageKDA();
        this.averageCS = graduateChampion.getAverageCS();
        this.averageCSPerMinute = graduateChampion.getAverageCSPerMinute();
        this.summaryGames = graduateChampion.getSummaryGames();
    }
}
