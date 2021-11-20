package ru.fadesml.graduates.domain.entity.enums;

import java.util.Objects;

public enum EServer {
    RU,
    TR,
    BR,
    OCE,
    LAS,
    EUNE,
    EUW,
    NA,
    KR,
    LAN,
    JP,
    UNKNOWN;

    public static String get(EServer server) {
        return Objects.requireNonNullElse(server, UNKNOWN).name();
    }
}
