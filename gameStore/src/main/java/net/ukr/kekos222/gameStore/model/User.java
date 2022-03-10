package net.ukr.kekos222.gameStore.model;

import net.ukr.kekos222.gameStore.entity.UserEntity;

public class User {
    private Long id;
    private String name;
    private String email;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
