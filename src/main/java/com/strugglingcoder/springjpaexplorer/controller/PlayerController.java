package com.strugglingcoder.springjpaexplorer.controller;

import com.strugglingcoder.springjpaexplorer.entity.Player;
import com.strugglingcoder.springjpaexplorer.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kini on 01-Feb-18.
 */

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(value="/player", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> createPlayer(@RequestBody Player player){
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

    @RequestMapping(value="/player", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>( playerRepository.findAll(),HttpStatus.OK);
    }

}
