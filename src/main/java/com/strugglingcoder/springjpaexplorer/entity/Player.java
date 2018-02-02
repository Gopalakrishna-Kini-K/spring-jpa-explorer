package com.strugglingcoder.springjpaexplorer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Kini on 31-Jan-18.
 */

@Entity
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native" )
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private String firstName;

    private String lastName;

    private String playerSpeciality;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlayerSpeciality() {
        return playerSpeciality;
    }

    public void setPlayerSpeciality(String playerSpeciality) {
        this.playerSpeciality = playerSpeciality;
    }
}
