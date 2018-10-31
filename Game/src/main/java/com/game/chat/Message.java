package com.game.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Message {

    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return first_name;
    }

    public void setName(String first_name) {
        this.first_name = first_name;
    }
}