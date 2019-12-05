package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;

public class MovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public MovePlayer() {
		super("moveplayer", MessageCode.TEAM_REMOVEPLAYER_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		Player player = null;
		String name = "";
		try {
			player = PlayerManager.getPlayer(args[0]);
			name = player.getName();
		} catch (NullPointerException e) {
			return MessageCode.TEAM_BAD_PLAYER.withArgs(args[0]);
		}
		ETeam oldTeam = null;
		for (ETeam team : get().getTeams())
			if (team.getPlayers().contains(name)) {
				oldTeam = team;
				break;
			}

		ETeam newTeam = ETeam.getByName(args[1]);
		if (newTeam == null)
			return MessageCode.TEAM_BAD_TEAM.withArgs(args[1]);

		oldTeam.removePlayers(name);
		newTeam.addPlayers(name);

		return MessageCode.TEAM_MOVEPLAYER_MOVED.withArgs(oldTeam.getNameWithColor(), newTeam.getNameWithColor());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(get().getPlayersRegistered(), args[0]);
		case 2:
			return filter(get().getTeams().stream().filter(t -> !t.getPlayers().contains(args[0]))
					.map(t -> t.getNameWithoutColor()), args[args.length - 1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
