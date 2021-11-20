package ru.fadesml.graduates.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "graduate_champions")
public class GraduateChampion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="graduate_id", nullable=false)
    private Graduate graduate;

    @ManyToOne
    @JoinColumn(name="champion_id", nullable=false)
    private Champion champion;

    @Column(nullable = false)
    private String averageKDA;

    @Column(nullable = false)
    private String averageCS;

    @Column(nullable = false)
    private String averageCSPerMinute;

    @Column(nullable = false)
    private Integer summaryGames;
}
