package guide_book.KTO_public_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuidebookDTO {
    private String title;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}
