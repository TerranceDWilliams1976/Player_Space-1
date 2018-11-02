package com.garage.lib;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "game_library")
//@Table(name = "game_library")
public class Lib {

    @Id
    @GeneratedValue
    private Integer game_id;
    private String game;

    // Game ID
    public Integer getGame_Id() {
        return game_id;
    }

    public void setGame_Id(Integer game_id) {
        this.game_id = game_id;
    }

    // Game Name
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}