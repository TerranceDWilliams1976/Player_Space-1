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
    private String FirstName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return FirstName;
    }

    public void setName(String FirstName) {
        this.FirstName = FirstName;
    }
}