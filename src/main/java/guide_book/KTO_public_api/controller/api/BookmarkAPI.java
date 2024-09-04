package guide_book.KTO_public_api.controller.api;

import guide_book.KTO_public_api.dto.BookmarkDTO;
import guide_book.KTO_public_api.service.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//CRUD 「作成（Create）」「読み出し（Read）」「更新（Update）」「削除（Delete）」
@RestController
@RequestMapping("/api/bookmark")
public class BookmarkAPI {

    private final BookmarkService bookmarkService;

    public BookmarkAPI(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    //ブックマークを作成
    @PostMapping("/add")
    public ResponseEntity<String> addBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
        try {
            bookmarkService.addBookmark(bookmarkDTO);
            return new ResponseEntity<>("Bookmark added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //ブックマークを読み出し
    //@GetMapping("/{id}")
    //public RequestBody<List<>>

    //ブックマークを削除
}
