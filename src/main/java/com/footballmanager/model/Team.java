package com.footballmanager.model;

import jakarta.persistence.*; // Обратите внимание на "jakarta" (актуально для Spring Boot 3.x)

@Entity // Помечает класс как сущность JPA
@Table(name = "teams") // Указывает имя таблицы в БД
public class Team {

    @Id // Помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Стратегия генерации ID (автоинкремент)
    private Long id;

    @Column(nullable = false) // Поле не может быть null в БД
    private String name;

    private String city;
    private Integer foundedYear;

    // Конструкторы
    public Team() {} // Обязательный пустой конструктор для JPA

    public Team(String name, String city, Integer foundedYear) {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
    }

    // Геттеры и сеттеры для ВСЕХ полей (ID тоже!)
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

    // toString (опционально, но полезно для логирования)
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