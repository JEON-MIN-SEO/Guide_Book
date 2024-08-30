package guide_book.KTO_public_api.repository;

import guide_book.KTO_public_api.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
