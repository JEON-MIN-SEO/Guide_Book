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

    private String title;

    private String destination;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "guidebook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayEntity> days = new ArrayList<>();

    public void addDay(DayEntity day) {
        days.add(day);
        day.setGuidebook(this);
    }

    public void removeDay(DayEntity day) {
        days.remove(day);
        day.setGuidebook(null);
    }
}
