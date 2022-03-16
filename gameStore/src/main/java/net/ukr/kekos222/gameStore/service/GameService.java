package net.ukr.kekos222.gameStore.service;

import net.ukr.kekos222.gameStore.entity.GameEntity;
import net.ukr.kekos222.gameStore.exception.NoEntityFoundException;
import net.ukr.kekos222.gameStore.model.Game;
import net.ukr.kekos222.gameStore.repo.GameRepo;
import net.ukr.kekos222.gameStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private UserRepo userRepo;

    public Game addGame(GameEntity entity){
        return Game.toModel(gameRepo.save(entity));
    }

    public void addGameToUser(Long userId, Long gameId) throws NoEntityFoundException {
        if(userRepo.findById(userId).isEmpty())
            throw new NoEntityFoundException("NO USER WITH ID: " + userId);
        if(gameRepo.findById(gameId).isEmpty())
            throw new NoEntityFoundException("NO GAME WITH ID: " + gameId);
        GameEntity gameEntity = gameRepo.getById(gameId);
        gameEntity.setUserEntity(userRepo.getById(userId));
        gameRepo.save(gameEntity);
    }
}
