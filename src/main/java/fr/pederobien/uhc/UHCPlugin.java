package fr.pederobien.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.LoadConfigurationCommand;
import fr.pederobien.uhc.commands.game.PauseCommand;
import fr.pederobien.uhc.commands.game.StartCommand;
import fr.pederobien.uhc.commands.game.StopCommand;
import fr.pederobien.uhc.commands.spawn.SaveSpawnCommand;
import fr.pederobien.uhc.commands.team.AddToRandomTeamCommand;
import fr.pederobien.uhc.commands.team.CreateTeamCommand;
import fr.pederobien.uhc.commands.team.RemoveAllTeamCommand;

public class UHCPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");
		
		new LoadConfigurationCommand(this, "loadconf");
		new PauseCommand(this, "pausegame");
		new StartCommand(this, "startgame");
		new StopCommand(this, "stopgame");
		new SaveSpawnCommand(this, "savespawn");
		new AddToRandomTeamCommand(this, "teamrandom");
		new CreateTeamCommand(this, "teamcreate");
		new RemoveAllTeamCommand(this, "teamremoveall");
	}

	@Override
	public void onDisable() {
		getLogger().info("UHC plugin disable");
	}
}
