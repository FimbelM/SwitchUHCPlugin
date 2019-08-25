package fr.pederobien.uhc.commands.team;

import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class AddToRandomTeamCommand extends AbstractCommand {
	private List<Team> teams;
	private List<Player> players;
	
	public AddToRandomTeamCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Random rand = new Random();
		players = PlayerManager.getPlayers();
		teams = TeamsManager.getTeams();
				
		int quotient = players.size() / teams.size();
		int reste = players.size() % teams.size();
		
		for (int i = 0; i < teams.size(); i++) {
			int maxPlayer = 0;
			if (reste == 0)
				maxPlayer = quotient;
			else if (reste > 0) {
				maxPlayer = quotient + 1;
				reste--;
			}
			for (int j = 0; j < maxPlayer; j++) {
				Player randomPlayer = players.get(rand.nextInt(players.size()));
				TeamsManager.joinTeam(teams.get(i).getName(), randomPlayer.getName());
				players.remove(randomPlayer);
			}
		}
		return true;
	}
}
