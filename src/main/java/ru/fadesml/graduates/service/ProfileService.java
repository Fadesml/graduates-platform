package ru.fadesml.graduates.service;

import ru.fadesml.graduates.payload.profile.GraduateProfile;
import ru.fadesml.graduates.payload.GraduateShortPreview;

import java.util.List;

public interface ProfileService {
    GraduateProfile getProfile(String name);
    List<GraduateShortPreview> getGraduatesShortPreview(int page, int size, String preGraduateName);
}
