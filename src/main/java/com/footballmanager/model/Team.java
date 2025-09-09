package com.footballmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team {

    @Id // Помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "There should be a team name")
    private String name;

    private String city;
    @NotNull(message = "The year of foundation is not specified")
    @Min(value = 1857, message = "The year of foundation should be more realistic")
    private Integer foundedYear;

    public Team() {} // пустой конструктор для JPA

    public Team(String name, String city, Integer foundedYear) {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", foundedYear=" + foundedYear +
                '}';
    }
}