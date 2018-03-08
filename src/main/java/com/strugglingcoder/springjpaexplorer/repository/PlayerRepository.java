package com.strugglingcoder.springjpaexplorer.repository;

import com.strugglingcoder.springjpaexplorer.entity.NationalTeam;
import com.strugglingcoder.springjpaexplorer.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Kini on 01-Feb-18.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByNationalTeam(NationalTeam nationalTeam);

}
