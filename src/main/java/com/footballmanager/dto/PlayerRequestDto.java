package com.footballmanager.dto;

import com.footballmanager.model.Position;

public class PlayerRequestDto {
    private String firstName;
    private String lastName;
    private Position position;
    private Integer number;
    private Long teamId;

    public PlayerRequestDto() {}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }
    public Long getTeamId() { return teamId; }
    public void setTeamId(Long team) { this.teamId = team; }
}
