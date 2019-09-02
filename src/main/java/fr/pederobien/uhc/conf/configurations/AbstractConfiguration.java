package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.game.IGame;

public abstract class AbstractConfiguration implements IConfiguration {
	private IGame game;
	private Spawn spawn;
	private String name;
	private List<Team> teams;

	@Override
	public IGame getGame() {
		return this.game;
	}

	@Override
	public Spawn getSpawn() {
		return spawn == null ? Spawn.DEFAULT : spawn;
	}

	@Override
	public void setSpawn(Spawn spawn) {
		this.spawn = spawn;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Team> getTeams() {
		return teams;
	}

	@Override
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	protected void setGame(IGame game) {
		this.game = game;
	}
}
