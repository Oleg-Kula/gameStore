package net.ukr.kekos222.gameStore.service;

import net.ukr.kekos222.gameStore.entity.UserEntity;
import net.ukr.kekos222.gameStore.exception.NoUserFoundException;
import net.ukr.kekos222.gameStore.exception.UserAlreadyExistException;
import net.ukr.kekos222.gameStore.model.User;
import net.ukr.kekos222.gameStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(UserEntity userEntity) throws UserAlreadyExistException {
        if(userRepo.findByEmail(userEntity.getEmail()) != null)
            throw new UserAlreadyExistException("User with this email already exists");
        return User.toModel(userRepo.save(userEntity));
    }

    public List<User> findAllUsers(){
        return userRepo.findAll().stream().map(User::toModel).collect(Collectors.toList());
    }

    public User findUserById(Long id) throws NoUserFoundException {
        if(userRepo.findById(id).isEmpty())
            throw new NoUserFoundException("No user found with id: " + id);
        return User.toModel(userRepo.getById(id));
    }

    public Long deleteUserById(Long id) throws NoUserFoundException {
        if(userRepo.findById(id).isEmpty())
            throw new NoUserFoundException("No user found with id: " + id);
        userRepo.deleteById(id);
        return id;
    }

}
