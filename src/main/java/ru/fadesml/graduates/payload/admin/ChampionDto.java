package ru.fadesml.graduates.payload.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionDto {
    @NotNull(message = "Название не должно быть пустым")
    private String name;
}
