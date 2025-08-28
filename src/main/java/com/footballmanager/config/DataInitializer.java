package com.footballmanager.config;

import com.footballmanager.model.Position;
import com.footballmanager.model.Team;
import com.footballmanager.model.Player;
import com.footballmanager.repository.TeamRepository;
import com.footballmanager.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(TeamRepository teamRepository, PlayerRepository playerRepository) {
        return args -> {
            Team dynamo = new Team("Dynamo Moscow", "Moscow", 1923);
            Team cska = new Team("CSKA Moscow", "Moscow", 1911);
            Team zenit = new Team("Zenit St. Petersburg", "St. Petersburg", 1925);

            teamRepository.saveAll(List.of(dynamo, cska, zenit));

            Player player1 = new Player("Andrey", "Lunev", Position.GOALKEEPER, 99, dynamo);
            Player player2 = new Player("Maksim", "Osipenko", Position.DEFENDER, 55, dynamo);
            Player player3 = new Player("Ivan", "Sergeev", Position.FORWARD, 33, dynamo);

            Player player4 = new Player("Igor", "Akinfeev", Position.GOALKEEPER, 35, cska);
            Player player5 = new Player("João", "Victor", Position.DEFENDER, 4, cska);
            Player player6 = new Player("", "Alerrandro", Position.FORWARD, 9, cska);

            Player player7 = new Player("Evgeniy", "Latyshonok", Position.GOALKEEPER, 1, zenit);
            Player player8 = new Player("Román", "Vega", Position.DEFENDER, 66, zenit);
            Player player9 = new Player("Aleksandr", "Sobolev", Position.FORWARD, 7, zenit);

            playerRepository.saveAll(List.of(player1, player2, player3, player4, player5, player6, player7, player8, player9));

            System.out.println("--> The database was initialized successfully");
        };
    }
}