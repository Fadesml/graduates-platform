package ru.fadesml.graduates.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fadesml.graduates.exception.NotFoundException;
import ru.fadesml.graduates.payload.GraduateShortPreview;
import ru.fadesml.graduates.service.ProfileService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final ProfileService profileService;

    @GetMapping
    public String displayMain(@RequestParam(required = false, defaultValue = "0") Integer page,
                              @RequestParam(required = false, defaultValue = "12") Integer size,
                              @RequestParam(required = false) String preGraduateName,
                              Model model) {
        List<GraduateShortPreview> graduates = profileService.getGraduatesShortPreview(page, size, preGraduateName);

        if (graduates.isEmpty()) {
            throw new NotFoundException("Graduates not found!");
        }
        model.addAttribute("graduates", graduates);
        return "main";
    }

    @GetMapping("/profile/{name}")
    public String displayProfile(@PathVariable String name, Model model) {
        model.addAttribute("profile", profileService.getProfile(name));

        return "profile";
    }
}
