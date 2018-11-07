package com.garage.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "games_i_want")
//@Table(name = "game_library")
public class Want {

    @Id
    @Column(name="game_id")
    private Integer gameId;
    private String game;

    // Game ID
    public Integer getGame_Id() {
        return gameId;
    }

    public void setGame_Id(Integer game_id) {
        this.gameId = game_id;
    }

    // Game Name
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}