package ru.fadesml.graduates.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fadesml.graduates.domain.entity.enums.EDivision;
import ru.fadesml.graduates.domain.entity.enums.ERank;
import ru.fadesml.graduates.domain.entity.enums.ERole;
import ru.fadesml.graduates.domain.entity.enums.EServer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "graduates")
public class Graduate {
    //info
    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EServer server;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String country;

    private String studentFeedback;

    @Column(nullable = false)
    private String coachFeedback;

    private String opgg;

    //starting rank
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERank startingRank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EDivision startingDivision;

    @Column(nullable = false)
    private Integer startingLP;

    //final rank
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERank finalRank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EDivision finalDivision;

    @Column(nullable = false)
    private Integer finalLP;

    //roles
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERole mainRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERole secondRole;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "graduate_plates",
            joinColumns = @JoinColumn(name = "graduate_id"),
            inverseJoinColumns = @JoinColumn(name = "plate_id"))
    private Set<Plate> plates;
}
