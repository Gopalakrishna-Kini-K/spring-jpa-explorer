package com.strugglingcoder.springjpaexplorer.controller;

import com.strugglingcoder.springjpaexplorer.entity.NationalTeam;
import com.strugglingcoder.springjpaexplorer.repository.NationalTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kini on 01-Feb-18.
 */
@RestController
public class NationalTeamController {

    @Autowired
    private NationalTeamRepository nationalTeamRepository;

    @RequestMapping(value="/nationalTeam", method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> createNationalTeam(@RequestBody NationalTeam nationalTeam){
        return new ResponseEntity<Object>( nationalTeamRepository.save(nationalTeam), HttpStatus.OK);
    }

    @GetMapping("/nationalTeam")
    public ResponseEntity< List<NationalTeam> > getAllNationalTeams(){
        return new ResponseEntity<>( nationalTeamRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value= "/nationalTeam", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<?> updateNationalTeam(@RequestBody NationalTeam nationalTeam){
        if ( nationalTeam == null || nationalTeam.getId() == null)
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        NationalTeam fromDb = nationalTeamRepository.findOne(nationalTeam.getId() );

        fromDb.setBoardName(nationalTeam.getBoardName());
        fromDb.setCountryName(nationalTeam.getCountryName());
        fromDb.setPlayers(nationalTeam.getPlayers());

        nationalTeamRepository.save(fromDb);

        return new ResponseEntity<>(fromDb, HttpStatus.OK);
    }
}
