package fr.pederobien.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.EditConfigurationCommand;
import fr.pederobien.uhc.commands.game.PauseCommand;
import fr.pederobien.uhc.commands.game.StartCommand;
import fr.pederobien.uhc.commands.game.StopCommand;
import fr.pederobien.uhc.commands.spawn.ListSpawnCommand;
import fr.pederobien.uhc.commands.spawn.RemoveSpawnCommand;
import fr.pederobien.uhc.commands.spawn.SaveSpawnCommand;
import fr.pederobien.uhc.commands.team.AddToRandomTeamCommand;
import fr.pederobien.uhc.commands.team.CreateTeamCommand;
import fr.pederobien.uhc.commands.team.RemoveAllTeamCommand;

public class UHCPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");
		
		new PauseCommand(this, "pausegame");
		new StartCommand(this, "startgame");
		new StopCommand(this, "stopgame");
		new SaveSpawnCommand(this, "spawnsave");
		new ListSpawnCommand(this, "spawnlist");
		new RemoveSpawnCommand(this, "spawnremove");
		new AddToRandomTeamCommand(this, "teamrandom");
		new CreateTeamCommand(this, "teamcreate");
		new RemoveAllTeamCommand(this, "teamremoveall");
		new EditConfigurationCommand(this, "edit");
		
		getServer().getPluginManager().registerEvents(AbstractCommand.listener, this);
		
		PluginDeposit.plugin = this;
	}

	@Override
	public void onDisable() {
		getLogger().info("UHC plugin disable");
	}
}
