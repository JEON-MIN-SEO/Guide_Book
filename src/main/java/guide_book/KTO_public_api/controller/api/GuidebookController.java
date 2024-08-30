package guide_book.KTO_public_api.controller.api;

import guide_book.KTO_public_api.dto.GuidebookDTO;
import guide_book.KTO_public_api.entity.GuidebookEntity;
import guide_book.KTO_public_api.service.GuidebookService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/guidebook")
public class GuidebookController {
    private final GuidebookService guidebookService;

    public GuidebookController(GuidebookService guidebookService) {
        this.guidebookService = guidebookService;
    }

    @PostMapping("/create")
    public GuidebookEntity createGuidebook(@RequestBody GuidebookDTO guidebookDTO) {
        return guidebookService.createGuidebook(guidebookDTO);
    }

    @GetMapping("/{id}")
    public GuidebookEntity getGuidebook(@PathVariable Long id) {
        return guidebookService.getGuidebook(id);
    }
}
