package net.ukr.kekos222.gameStore.controller;

import net.ukr.kekos222.gameStore.entity.GameEntity;
import net.ukr.kekos222.gameStore.exception.NoEntityFoundException;
import net.ukr.kekos222.gameStore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<String> addGame(@RequestBody GameEntity gameEntity){
        gameService.addGame(gameEntity);
        return ResponseEntity.ok().body("Game added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> addGameToUser(@RequestParam Long userId,
                                        @PathVariable Long id){
        try {
            gameService.addGameToUser(userId, id);
            return ResponseEntity.ok().body("Added");
        } catch (NoEntityFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
