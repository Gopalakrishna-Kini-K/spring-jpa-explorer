package com.strugglingcoder.springjpaexplorer.repository;

import com.strugglingcoder.springjpaexplorer.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kini on 01-Feb-18.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
