package net.ukr.kekos222.gameStore.controller;

import net.ukr.kekos222.gameStore.entity.UserEntity;
import net.ukr.kekos222.gameStore.exception.NoEntityFoundException;
import net.ukr.kekos222.gameStore.exception.UserAlreadyExistException;
import net.ukr.kekos222.gameStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserEntity user){
        try{
            userService.createUser(user);
            return ResponseEntity.ok().body("User was created!");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUserById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userService.findUserById(id));
        } catch (NoEntityFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return ResponseEntity.ok().body("User deleted. id: " + id);
        } catch(NoEntityFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
