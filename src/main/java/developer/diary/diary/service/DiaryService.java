package developer.diary.diary.service;

import developer.diary.diary.dto.EntryRequestDTO;
import developer.diary.diary.entity.Category;
import developer.diary.diary.entity.Entry;
import developer.diary.diary.repository.CategoryRepository;
import developer.diary.diary.repository.EntryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final EntryRepository entryRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Entry saveEntry(EntryRequestDTO dto) {
        Entry entry = new Entry();
        entry.setTitle(dto.getTitle());
        entry.setContent(dto.getContent());
        entry.setStatus(dto.getStatus());
        entry.setUserId(dto.getUserId());
        entry.setCreatedAt(LocalDateTime.now());
        entry.setUpdatedAt(LocalDateTime.now());

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            entry.setCategory(category);
        }

        return entryRepository.save(entry);
    }

    public List<Entry> getUserEntries(UUID userId) {
        return entryRepository.findByUserIdAndIsDeletedFalseOrderByCreatedAtDesc(userId);
    }
}