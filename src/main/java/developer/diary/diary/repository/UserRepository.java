package developer.diary.diary.repository;


import developer.diary.diary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByProviderAndProviderUserId(
            String provider,
            String providerUserId
    );
    Optional<UserEntity> findByEmail(String email);
}