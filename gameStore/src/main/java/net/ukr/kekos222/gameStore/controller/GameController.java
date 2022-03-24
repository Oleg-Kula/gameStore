package net.ukr.kekos222.gameStore.controller;

import net.ukr.kekos222.gameStore.entity.GameEntity;
import net.ukr.kekos222.gameStore.exception.NoEntityFoundException;
import net.ukr.kekos222.gameStore.model.Game;
import net.ukr.kekos222.gameStore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok().body(gameService.getAllGames());
    }

    @PostMapping
    public ResponseEntity<String> addGame(@RequestBody GameEntity gameEntity){
        return ResponseEntity.ok().body(gameService.addGame(gameEntity).getTitle() +" added");
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
