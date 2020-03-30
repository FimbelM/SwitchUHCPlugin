package fr.martinfimbel.switchuhc.configurations;

import java.time.LocalTime;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.game.switching.SwitchGame;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class SwitchConfiguration extends AbstractConfiguration implements ISwitchGameConfiguration {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private static final Double DEFAULT_INITIAL_BORDER_SIZE = new Double(3000);
	private static final Double DEFAULT_FINAL_BORDER_SIZE = new Double(20);
	private static final LocalTime DEFAULT_FRACTION_TIME = LocalTime.of(0, 45, 0);
	private static final LocalTime DEFAULT_WARNING_TIME = LocalTime.of(0, 5, 0);
	private static final LocalTime DEFAULT_PVP_TIME = LocalTime.of(0, 20, 0);
	private static final LocalTime DEFAULT_SWITCH_TIME = LocalTime.of(0, 20, 0);
	private static final LocalTime DEFAULT_START_SWITCH_TIME = LocalTime.of(0, 30, 0);
	private static final Double DEFAULT_BORDER_SPEED = 1.0;
	private static final Integer DEFAULT_NUMBER_OF_PLAYER_SWITCHABLE = 1;
	private Block borderCenter;
	private Double initialBorderDiameter, finalBorderDiameter, borderSpeed;
	private Integer numberOfPlayerSwitchable;
	private LocalTime switchTime, startSwitchTime, fractionTime, warningTime, pvpTime;
	
	
	public SwitchConfiguration(String name) {
		super(name);
		setGame(new SwitchGame(this));
	}

	@Override
	public Block getBorderCenter() {
		return borderCenter == null ? DEFAULT_CENTER : borderCenter;
	}

	@Override
	public void setBorderCenter(Block borderCenter) {
		this.borderCenter = borderCenter;
	}

	@Override
	public void setBorderCenter(String x, String z) {
		borderCenter = WorldManager.getBelowHighestBlockYAt(Integer.parseInt(x), Integer.parseInt(z));
	}

	@Override
	public Double getInitialBorderDiameter() {
		return initialBorderDiameter == null ? DEFAULT_INITIAL_BORDER_SIZE : initialBorderDiameter;
	}

	@Override
	public void setInitialBorderDiameter(double initialBorderDiameter) {
		this.initialBorderDiameter = initialBorderDiameter;
	}

	@Override
	public Double getFinalBorderDiameter() {
		return finalBorderDiameter == null ? DEFAULT_FINAL_BORDER_SIZE : finalBorderDiameter;
	}

	@Override
	public void setFinalBorderDiameter(double finalBorderDiameter) {
		this.finalBorderDiameter = finalBorderDiameter;
	}

	@Override
	public LocalTime getFractionTime() {
		return fractionTime == null ? DEFAULT_FRACTION_TIME : fractionTime;
	}

	@Override
	public void setFractionTime(LocalTime fractionTime) {
		this.fractionTime = fractionTime;
	}

	@Override
	public LocalTime getWarningTime() {
		return warningTime == null ? DEFAULT_WARNING_TIME : getGameTime().minusSeconds(warningTime.toSecondOfDay());
	}

	@Override
	public void setWarningTime(LocalTime warningTime) {
		this.warningTime = warningTime;
	}

	@Override
	public LocalTime getPvpTime() {
		return pvpTime == null ? DEFAULT_PVP_TIME : pvpTime;
	}

	@Override
	public void setPvpTime(LocalTime pvpTime) {
		this.pvpTime = pvpTime;
	}

	@Override
	public Double getBorderSpeed() {
		return borderSpeed == null ? DEFAULT_BORDER_SPEED : borderSpeed;
	}

	@Override
	public void setBorderSpeed(double borderSpeed) {
		this.borderSpeed = borderSpeed;
	}

	@Override
	public LocalTime getPeriodSwitchTime() {
		return switchTime == null ? DEFAULT_SWITCH_TIME : switchTime;
	}

	@Override
	public void setPeriodSwitchTime(LocalTime switchTime) {
		this.switchTime = switchTime;
	}

	@Override
	public LocalTime getStartSwitchTime() {
		return startSwitchTime == null ? DEFAULT_START_SWITCH_TIME : startSwitchTime;
	}

	@Override
	public void setStartSwitchTime(LocalTime startSwitchTime) {
		this.startSwitchTime = startSwitchTime;
	}
	
	@Override
	public Integer getNumberOfPlayerSwitchable() {
		return numberOfPlayerSwitchable == null ? DEFAULT_NUMBER_OF_PLAYER_SWITCHABLE : numberOfPlayerSwitchable;
	}
	
	@Override
	public void setNumberOfPlayerSwitchable(Integer numberOfSwitchablePlayer) {
		this.numberOfPlayerSwitchable = numberOfSwitchablePlayer;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Border center : " + showBlock(getBorderCenter()) + "\n");
		builder.append("Initial border diameter : " + getInitialBorderDiameter() + " blocks\n");
		builder.append("Final border diameter : " + getFinalBorderDiameter() + " blocks\n");
		builder.append("Player not revived time : " + showTime(getFractionTime()) + "\n");
		builder.append("Warning time : " + showTime(getWarningTime()) + "\n");
		builder.append("Pvp time : " + showTime(getPvpTime()) + "\n");
		builder.append("Border speed : " + getBorderSpeed() + " blocks/s\n");
		builder.append("First switch time : "+ showTime(getStartSwitchTime())+ "\n");
		builder.append("Switch every : " + showTime(getPeriodSwitchTime())+ "\n");
		builder.append("Number of players switched : " + getNumberOfPlayerSwitchable() + "\n");
		return builder.toString();
	}

	@Override
	public void reset() {
		super.reset();
		borderCenter = null;
		borderSpeed = null;
		finalBorderDiameter = null;
		fractionTime = null;
		initialBorderDiameter = null;
		pvpTime = null;
		warningTime = null;
		startSwitchTime = null;
		switchTime = null;
		numberOfPlayerSwitchable = null;
	}


}
