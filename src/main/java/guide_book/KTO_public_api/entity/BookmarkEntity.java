package guide_book.KTO_public_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@Table(name = "bookmarks")
public class BookmarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore //객체를 json으로 직렬화 하지 않는 어노테이션 즉, Json으로 만들지 않고 보낸다.
    @ManyToOne(fetch = FetchType.LAZY) //여러 BookmarkEntity가 하나의 UserEntity에 연결되는 다대일(Many-to-One) 관계를 설정합니다.
    // (제로 데이터가 필요할 때까지 연관된 엔티티를 로딩하지 않습니다. 즉, 연관된 엔티티는 처음에는 로드되지 않고,
    // 해당 엔티티의 데이터에 접근할 때 로딩됩니다.)
    @JoinColumn(name = "user_id")
    private String userId;

    private String contentId;
}
