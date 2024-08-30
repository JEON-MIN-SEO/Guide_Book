package guide_book.KTO_public_api.repository;

import guide_book.KTO_public_api.entity.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<DayEntity, Long> {
}
