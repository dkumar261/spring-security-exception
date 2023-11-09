package com.sx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.dozermapper.core.Mapper;
import com.sx.domain.Player;
import com.sx.model.PlayerModel;
import com.sx.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PaylerController {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private Mapper mapper; 

	@PostMapping(value = "/ws/v1/player")
	public Player addPlayer(@RequestBody PlayerModel playerModel) {
		log.info("addPlayer() method is called " + " To save the player ");
		Player playerEntity = mapper.map(playerModel, Player.class);
		
		Player addPlayer = playerService.addPlayer(playerEntity);
		return addPlayer;

	}
}
