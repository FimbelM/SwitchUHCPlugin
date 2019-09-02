package fr.pederobien.uhc.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.task.TimeTask;

public interface IScoreboard extends IScoreboardState {
	
	IScoreboardState getCurrentState();
	
	IScoreboardState setCurrentState(IScoreboardState current);
	
	IScoreboardState getInitialState();
	
	IScoreboardState getBeforeBorderMoveState();
	
	IScoreboardState getAfterBorderMoveState();
	
	IScoreboardState getPauseState();
	
	IScoreboardState getStopState();
	
	TimeTask getTask();
	
	ChatColor getChatColor();
	
	Player getPlayer();
}
