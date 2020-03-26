package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.PlayerManager;

public class MovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public MovePlayer() {
		super("moveplayer", MessageCode.TEAM_MOVEPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		Player player = PlayerManager.getPlayer(args[0]);

		if (player == null) {
			sendMessage(MessageCode.TEAM_BAD_PLAYER, args[0]);
			return;
		}

		ITeam oldTeam = null;
		for (ITeam team : get().getTeams())
			if (team.getPlayers().contains(player)) {
				oldTeam = team;
				break;
			}

		if (oldTeam == null) {
			sendMessage(MessageCode.TEAM_MOVEPLAYER_PLAYER_NOT_IN_TEAM, player.getName());
			return;
		}

		ITeam newTeam = get().getTeamByName(args[1]);
		if (newTeam == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, args[1]);
			return;
		}

		oldTeam.removePlayer(player);
		newTeam.addPlayer(player);

		sendMessage(MessageCode.TEAM_MOVEPLAYER_MOVED, player.getName(), oldTeam.getColoredName(), newTeam.getColoredName());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(get().getPlayersRegistered(), args[0]);
		case 2:
			return filter(get().getTeams().stream().filter(t -> !t.getPlayers().contains(PlayerManager.getPlayer(args[0]))).map(t -> t.getName()),
					args[args.length - 1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
