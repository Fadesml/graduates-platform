package ru.fadesml.graduates.domain.entity.enums;

public enum EDivision {
    I,
    II,
    III,
    IV;

    public static String get(EDivision division) {
        return (division != null) ? division.name() : "";
    }
}
