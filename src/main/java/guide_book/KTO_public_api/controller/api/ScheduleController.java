package guide_book.KTO_public_api.controller.api;

import guide_book.KTO_public_api.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/add")
    public ScheduleEntity addSchedule(@RequestParam Long dayId, @RequestParam Long contentId) {
        return scheduleService.addScheduleToDay(dayId, contentId);
    }

    @DeleteMapping("/remove/{id}")
    public void removeSchedule(@PathVariable Long id) {
        scheduleService.removeSchedule(id);
    }
}
