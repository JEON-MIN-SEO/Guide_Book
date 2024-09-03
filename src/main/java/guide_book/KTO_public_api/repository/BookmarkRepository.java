package guide_book.KTO_public_api.repository;

import guide_book.KTO_public_api.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
}
