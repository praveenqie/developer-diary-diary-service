package developer.diary.diary.repository;

import developer.diary.diary.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntryRepository extends JpaRepository<Entry, UUID> {
    // Fetch all active notes for a specific user, sorted by newest first
    List<Entry> findByUserIdAndIsDeletedFalseOrderByCreatedAtDesc(UUID userId);

    // Search within the content (Basic keyword search)
    List<Entry> findByContentContainingIgnoreCase(String keyword);
}