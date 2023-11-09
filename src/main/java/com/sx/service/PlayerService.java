package com.sx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.domain.Player;
import com.sx.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player addPlayer(Player player) {
		Player save = playerRepository.save(player);
		return save;
	}
}
