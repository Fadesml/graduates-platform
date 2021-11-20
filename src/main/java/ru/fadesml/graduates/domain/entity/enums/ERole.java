package ru.fadesml.graduates.domain.entity.enums;

import java.util.Objects;

public enum ERole {
    TOP,
    JGL,
    MID,
    SUP,
    ADC,
    UNKNOWN;

    public static String get(ERole role) {
        return Objects.requireNonNullElse(role, UNKNOWN).name();
    }
}
