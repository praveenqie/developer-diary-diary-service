package developer.diary.diary.controller;

import developer.diary.diary.dto.EntryRequestDTO;
import developer.diary.diary.entity.Entry;
import developer.diary.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/diary")
@CrossOrigin(origins = "http://localhost:4200") // Adjust for your Angular port
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/publish")
    public ResponseEntity<Entry> publishEntry(@RequestBody EntryRequestDTO entryDto) {
        Entry savedEntry = diaryService.saveEntry(entryDto);
        return ResponseEntity.ok(savedEntry);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Entry>> fetchUserEntries(@PathVariable UUID userId) {
        return ResponseEntity.ok(diaryService.getUserEntries(userId));
    }
}