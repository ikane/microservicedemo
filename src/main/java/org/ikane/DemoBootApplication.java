package org.ikane;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class DemoBootApplication extends SpringBootServletInitializer {

	@Autowired
	private TeamRepository teamRepository;

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Team team = new Team();
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);
		
		Player player = new Player();
		player.setName("Player1");
		player.setPosition("Position1");
		
		team.getPlayers().add(player);

		team = new Team();
		team.setLocation("Washington");
		team.setName("Generals");
		list.add(team);

		teamRepository.save(list);
	}

	/**
	 * Run as JAR
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoBootApplication.class, args);
	}

	/**
	 * Run app as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoBootApplication.class);
	}
}
