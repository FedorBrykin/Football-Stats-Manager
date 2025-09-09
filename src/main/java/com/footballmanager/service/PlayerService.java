package com.footballmanager.service;

import com.footballmanager.dto.PlayerDto;
import com.footballmanager.dto.PlayerRequestDto;
import com.footballmanager.exception.ResourceNotFoundException;
import com.footballmanager.model.Player;
import com.footballmanager.model.Team;
import com.footballmanager.repository.PlayerRepository;
import com.footballmanager.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;


    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;

    }

    // Преобразование Player в PlayerDto
    private PlayerDto convertToDto(Player player) {
        String teamName = (player.getTeam() != null) ? player.getTeam().getName() : null;
        return new PlayerDto(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getPosition(),
                player.getNumber(),
                teamName
        );
    }

    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<PlayerDto> getPlayersByTeamId(Long teamId) {
        return playerRepository.findByTeamId(teamId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<PlayerDto> getPlayersById(Long getId) {
        return playerRepository.findById(getId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PlayerDto createPlayer(PlayerRequestDto playerRequestDto) {
        Team team = teamRepository.findById(playerRequestDto.getTeamId())
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + playerRequestDto.getTeamId()));
        Player player = new Player();
        player.setFirstName(playerRequestDto.getFirstName());
        player.setLastName(playerRequestDto.getLastName());
        player.setPosition(playerRequestDto.getPosition());
        player.setNumber(playerRequestDto.getNumber());
        player.setTeam(team);
        Player savedPlayer = playerRepository.save(player);
        return convertToDto(savedPlayer);
    }

    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        playerRepository.delete(player);
    }
}