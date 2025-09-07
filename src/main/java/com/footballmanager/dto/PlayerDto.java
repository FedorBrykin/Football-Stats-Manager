package com.footballmanager.dto;

import com.footballmanager.model.Position;
import com.footballmanager.model.Team;

public class PlayerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private Integer number;
    private String teamName;

    public PlayerDto() {}

    public PlayerDto(Long id, String firstName, String lastName, Position position, Integer number, String teamName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.teamName = teamName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }
    public String getTeam() { return teamName; }
    public void setTeam(String team) { this.teamName = team; }
}