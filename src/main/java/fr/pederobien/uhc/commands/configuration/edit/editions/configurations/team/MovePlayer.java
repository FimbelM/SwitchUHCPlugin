package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;

public class MovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public MovePlayer() {
		super("moveplayer", MessageCode.TEAM_REMOVEPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		Player player = null;
		String name = "";
		try {
			player = PlayerManager.getPlayer(args[0]);
			name = player.getName();
		} catch (NullPointerException e) {
			sendMessage(MessageCode.TEAM_BAD_PLAYER, args[0]);
			return;
		}

		EColor oldTeam = null;
		for (EColor team : get().getTeams())
			if (team.getPlayers().contains(name)) {
				oldTeam = team;
				break;
			}

		EColor newTeam = EColor.getByName(args[1]);
		if (newTeam == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, args[1]);
			return;
		}

		oldTeam.removePlayers(name);
		newTeam.addPlayers(name);

		sendMessage(MessageCode.TEAM_MOVEPLAYER_MOVED, oldTeam.getNameWithColor(), newTeam.getNameWithColor());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(get().getPlayersRegistered(), args[0]);
		case 2:
			return filter(get().getTeams().stream().filter(t -> !t.getPlayers().contains(args[0])).map(t -> t.getNameWithoutColor()),
					args[args.length - 1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
