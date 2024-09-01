package guide_book.KTO_public_api.repository;

import guide_book.KTO_public_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUserEmail(String userEmail); //同じユーザがあるか確認するため
    //他にidを探すメッソどー必要
}

