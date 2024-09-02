package guide_book.KTO_public_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DayDTO {
    private Long id;
    private int dayNumber;
    private List<BookmarkDTO> contentList;
}
