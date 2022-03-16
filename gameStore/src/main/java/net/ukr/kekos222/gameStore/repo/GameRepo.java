package net.ukr.kekos222.gameStore.repo;

import net.ukr.kekos222.gameStore.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<GameEntity, Long> {
}
