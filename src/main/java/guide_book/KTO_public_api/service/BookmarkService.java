package guide_book.KTO_public_api.service;

import guide_book.KTO_public_api.dto.BookmarkDTO;
import guide_book.KTO_public_api.entity.BookmarkEntity;
import guide_book.KTO_public_api.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

@Service//ブックマークについてのサービス
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    //作成
    public void addBookmark(BookmarkDTO bookmarkDTO) {
        //유효성 검사 빈 값인지 확인

        //중복 검사 or 유니크?

        BookmarkEntity bookmarkEntity = new BookmarkEntity();
        bookmarkEntity.setUserId(bookmarkDTO.getUserId());
        bookmarkEntity.setContentId(bookmarkDTO.getContentId());
        bookmarkRepository.save(bookmarkEntity);
    }


}
