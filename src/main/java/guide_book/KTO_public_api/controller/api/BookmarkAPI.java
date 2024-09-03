package guide_book.KTO_public_api.controller.api;

import guide_book.KTO_public_api.dto.BookmarkDTO;
import guide_book.KTO_public_api.service.BookmarkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkAPI {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping
    public void addBookmark(@RequestBody BookmarkDTO bookmarkDTO) {

    }
}
