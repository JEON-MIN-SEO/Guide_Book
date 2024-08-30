package guide_book.KTO_public_api.service;

import guide_book.KTO_public_api.dto.GuidebookDTO;
import guide_book.KTO_public_api.entity.DayEntity;
import guide_book.KTO_public_api.entity.GuidebookEntity;
import guide_book.KTO_public_api.repository.GuidebookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class GuidebookService {
    private final GuidebookRepository guidebookRepository;

    public GuidebookService(GuidebookRepository guidebookRepository) {
        this.guidebookRepository = guidebookRepository;
    }

    public GuidebookEntity createGuidebook(GuidebookDTO guidebookDTO) {
        GuidebookEntity guidebook = new GuidebookEntity();
        guidebook.setTitle(guidebookDTO.getTitle());
        guidebook.setDestination(guidebookDTO.getDestination());
        guidebook.setStartDate(guidebookDTO.getStartDate());
        guidebook.setEndDate(guidebookDTO.getEndDate());

        //ChronoUnit.DAYS.betweenはjava 8から導入された’java.time'パッケージのChronoUnit Enumクラスに含まれたメソッドで
        //二つの日付けの間の計算をしてくれる　（８・２２〜８・３０＝８）
        long daysBetween = ChronoUnit.DAYS.between(guidebook.getStartDate(), guidebook.getEndDate()) + 1;
        for (int i = 0; i < daysBetween; i++) {
            DayEntity day = new DayEntity();
            day.setDayNumber(i + 1);
            guidebook.addDay(day);
        }

        return guidebookRepository.save(guidebook);
    }

    public GuidebookEntity getGuidebook(Long id) {
        return guidebookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guidebook not found"));
    }
}
