package ru.fadesml.graduates.domain.entity.enums;

import java.util.Objects;

public enum ERank {
    UNRANKED,
    IRON,
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM,
    DIAMOND,
    MASTER,
    GRANDMASTER,
    CHALLENGER;

    public static String get(ERank rank) {
        return Objects.requireNonNullElse(rank, UNRANKED).name();
    }
}
