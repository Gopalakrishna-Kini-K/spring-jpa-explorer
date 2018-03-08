package com.strugglingcoder.springjpaexplorer.controller;

import com.strugglingcoder.springjpaexplorer.entity.NationalTeam;
import com.strugglingcoder.springjpaexplorer.entity.Player;
import com.strugglingcoder.springjpaexplorer.repository.NationalTeamRepository;
import com.strugglingcoder.springjpaexplorer.repository.PlayerRepository;
import org.omg.PortableInterceptor.HOLDING;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kini on 01-Feb-18.
 */

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    NationalTeamRepository nationalTeamRepository;

    @RequestMapping(value="/player/nationalTeam/{nId}", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> createPlayer(@RequestBody Player player, @PathVariable(value = "nId") long nationalTeamId){
        NationalTeam nationalTeam = nationalTeamRepository.findOne(nationalTeamId);
        player.setNationalTeam(nationalTeam);
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

    @RequestMapping(value="/player", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>( playerRepository.findAll(),HttpStatus.OK);
    }

    @RequestMapping( value = "/player/nationalTeam/{nId}", method = RequestMethod.GET )
    public ResponseEntity< List<Player> > getAllPlayersOfANationalTeam(@PathVariable(value = "nId") long nationalId) {
        NationalTeam nationalTeam = nationalTeamRepository.findOne(nationalId);
        List <Player> listOfPlayersByNationalTeam = playerRepository.findByNationalTeam(nationalTeam);
        return new ResponseEntity<List<Player>>(listOfPlayersByNationalTeam, HttpStatus.OK);
    }

    @RequestMapping( value = "/player/{pId}", method = RequestMethod.DELETE )
    public ResponseEntity<?> deletePlayer( @PathVariable(value = "pId") long playerId){
        playerRepository.delete( playerRepository.findOne(playerId) );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping( value = "/player/{pid}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePatient( @RequestBody Player player, @PathVariable(value = "pid") long patiendId){
        Player fromDb = playerRepository.findOne(patiendId);
        fromDb.setPlayerSpeciality( player.getPlayerSpeciality() );
        playerRepository.save(fromDb);
        return new ResponseEntity(HttpStatus.OK);
    }



}
