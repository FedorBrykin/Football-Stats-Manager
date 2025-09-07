package com.footballmanager.controller;

import com.footballmanager.model.Team;
import com.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // контроллер, обрабатывающий HTTP-запросы
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id)
                .orElseThrow(() -> new RuntimeException("The command with id " + id + " was not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201: Created
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeamInfo(@PathVariable Long id, @RequestBody Team teamDetails) {
        return teamService.updateTeam(id, teamDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204: No Content
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}