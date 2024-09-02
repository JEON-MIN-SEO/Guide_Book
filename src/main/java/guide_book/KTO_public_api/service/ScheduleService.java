package guide_book.KTO_public_api.service;

import guide_book.KTO_public_api.entity.DayEntity;
import guide_book.KTO_public_api.repository.DayRepository;
import guide_book.KTO_public_api.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final DayRepository dayRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, DayRepository dayRepository) {
        this.scheduleRepository = scheduleRepository;
        this.dayRepository = dayRepository;
    }

    public ScheduleEntity addScheduleToDay(Long dayId, Long contentId) {
        DayEntity day = dayRepository.findById(dayId)
                .orElseThrow(() -> new IllegalArgumentException("Day not found"));

        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setContentId(contentId);
        day.addSchedule(schedule);

        return scheduleRepository.save(schedule);
    }

    public void removeSchedule(Long scheduleId) {
        ScheduleEntity schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));
        schedule.getDay().removeSchedule(schedule);
        scheduleRepository.delete(schedule);
    }
}
