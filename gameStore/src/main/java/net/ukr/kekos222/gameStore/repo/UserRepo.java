package net.ukr.kekos222.gameStore.repo;

import net.ukr.kekos222.gameStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
