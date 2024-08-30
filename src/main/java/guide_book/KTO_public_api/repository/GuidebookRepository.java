package guide_book.KTO_public_api.repository;

import guide_book.KTO_public_api.entity.GuidebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidebookRepository extends JpaRepository<GuidebookEntity, Long> {
}
