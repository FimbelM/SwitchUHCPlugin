package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;

public abstract class AbstractConfiguration<G, C> implements IConfiguration<G, C> {
	private G game;
	private Spawn spawn;
	private String name;
	private List<Team> teams;

	@Override
	public G getGame() {
		return this.game;
	}

	@Override
	public void setGame(G game) {
		this.game = game;
	}

	@Override
	public Spawn getSpawn() {
		return spawn;
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
}
