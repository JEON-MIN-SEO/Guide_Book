package guide_book.KTO_public_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "guidebooks")
public class GuidebookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //（関連したEntityを実際利用する前にはロードしない）
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name = "title")
    private String title;

    @Column(name = "destination")
    private String destination;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "guidebooks", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayEntity> days = new ArrayList<>();

//    public void addDay(DayEntity day) {
//        days.add(day);
//        day.setGuidebook(this);
//    }
//
//    public void removeDay(DayEntity day) {
//        days.remove(day);
//        day.setGuidebook(null);
//    }
}
