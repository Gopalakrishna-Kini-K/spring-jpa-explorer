package com.strugglingcoder.springjpaexplorer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Kini on 31-Jan-18.
 */

@Entity
@Table(name="national_team")
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name="native" , strategy = "native")
    private Long id;

    private String countryName;

    private String boardName;

    //@OneToMany( fetch = FetchType.LAZY , cascade = CascadeType.ALL) = deletes child entities along with the parent
    @OneToMany( fetch = FetchType.LAZY , cascade = CascadeType.PERSIST) // deletes only parent entity. Players will show up in GET /player even if nationalTeam deleted.
    private Set<Player> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
