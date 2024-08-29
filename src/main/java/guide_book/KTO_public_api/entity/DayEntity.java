package guide_book.KTO_public_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "days")
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dayNumber;

    @ManyToOne
    @JoinColumn(name = "guidebook_id")
    private GuidebookEntity guidebook;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduleEntity> schedules = new ArrayList<>();

    public void addSchedule(ScheduleEntity schedule) {
        schedules.add(schedule);
        schedule.setDay(this);
    }

}
