package com.footballmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id // Помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;
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