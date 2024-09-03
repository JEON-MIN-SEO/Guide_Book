package guide_book.KTO_public_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@Table(name = "days")
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dayNumber;

    @JsonIgnore //
    @ManyToOne(fetch = FetchType.LAZY) //（関連したEntityを実際利用する前にはロードしない）
    @JoinColumn(name = "guidebook_id") //
    private GuidebookEntity guidebook;

    @Column(columnDefinition = "TEXT")
    private String contentJson;


}
