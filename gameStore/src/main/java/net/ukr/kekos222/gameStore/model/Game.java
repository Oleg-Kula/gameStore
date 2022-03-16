package net.ukr.kekos222.gameStore.model;

import net.ukr.kekos222.gameStore.entity.GameEntity;

public class Game {

    private Long id;
    private String title;
    private String description;
    private String genre;

    public static Game toModel(GameEntity entity){
        Game model = new Game();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setGenre(entity.getGenre());

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
