package com.sx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sx.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
