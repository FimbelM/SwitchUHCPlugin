package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.game.IGame;

public class ConfigurationContext implements IConfiguration, IGame {
	private IConfiguration configuration;
	
	public void setCurrentConfiguration(IConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public IConfiguration getCurrentConfiguration() {
		return configuration;
	}

	@Override
	public void initiate() {
		getGame().initiate();
	}

	@Override
	public void start() {
		getGame().start();
	}

	@Override
	public void stop() {
		getGame().stop();
	}

	@Override
	public void pause() {
		getGame().pause();
	}

	@Override
	public void relaunch() {
		getGame().pause();
	}

	@Override
	public IGame getGame() {
		return configuration.getGame();
	}

	@Override
	public void setGame(IGame game) {
		configuration.setGame(game);
	}

	@Override
	public Spawn getSpawn() {
		return configuration.getSpawn();
	}

	@Override
	public void setSpawn(Spawn spawn) {
		configuration.setSpawn(spawn);
	}

	@Override
	public String getName() {
		return configuration.getName();
	}

	@Override
	public void setName(String name) {
		configuration.setName(name);
	}

	@Override
	public List<Team> getTeams() {
		return configuration.getTeams();
	}

	@Override
	public void setTeams(List<Team> teams) {
		configuration.setTeams(teams);
	}
}
