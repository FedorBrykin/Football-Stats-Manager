package com.footballmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING) // Сохраняет значение enum как строку в БД
    private Position position;

    private Integer number; // Игровой номер

    // Many-to-One: много игроков могут играть в одной команде
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {}

    public Player(String firstName, String lastName, Position position, Integer number, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.team = team;
    }

    // Геттеры и сеттеры для всех полей
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
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", number=" + number +
                ", team=" + (team != null ? team.getName() : "null") +
                '}';
    }
}