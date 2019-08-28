package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.game.IGameBase;
import fr.pederobien.uhc.game.IGameBaseState;

public class ConfigurationContext implements IGameBase<IGameBaseState>, IConfiguration<IGameBase<IGameBaseState>> {
	private IConfiguration<IGameBase<IGameBaseState>> configuration;
	
	public void setCurrentConfiguration(IConfiguration<IGameBase<IGameBaseState>> configuration) {
		this.configuration = configuration;
	}
	
	public IConfiguration<IGameBase<IGameBaseState>> getCurrentConfiguration() {
		return configuration;
	}

	@Override
	public void start() {
		getGame().start();
	}

	@Override
	public void pause(IGameBaseState before) {
		getGame().pause(before);
	}

	@Override
	public void stop() {
		getGame().stop();
	}

	@Override
	public IGameBaseState getCurrentState() {
		return getGame().getCurrentState();
	}

	@Override
	public void relaunched() {
		getGame().relaunched();
	}

	@Override
	public IGameBase<IGameBaseState> getGame() {
		return configuration.getGame();
	}

	@Override
	public void setGame(IGameBase<IGameBaseState> game) {
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
