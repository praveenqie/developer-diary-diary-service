package developer.diary.diary.repository;

import developer.diary.diary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query to find Global categories OR a specific user's categories
    List<Category> findByIsGlobalTrueOrUserId(UUID userId);
}