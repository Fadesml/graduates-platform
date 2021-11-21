package ru.fadesml.graduates.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraduatePreviewPage {
    private List<GraduateShortPreview> graduates;
    private List<Pagination> pagesBefore;
    private Pagination currentPage;
    private List<Pagination> pagesAfter;
}
