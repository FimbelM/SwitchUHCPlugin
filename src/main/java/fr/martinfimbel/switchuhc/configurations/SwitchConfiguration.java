package fr.martinfimbel.switchuhc.configurations;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.game.switching.SwitchGame;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class SwitchConfiguration extends AbstractBorderConfiguration implements ISwitchGameConfiguration {
	private static final LocalTime DEFAULT_FRACTION_TIME = LocalTime.of(0, 45, 0);
	private static final LocalTime DEFAULT_WARNING_TIME = LocalTime.of(0, 5, 0);
	private static final LocalTime DEFAULT_PVP_TIME = LocalTime.of(0, 20, 0);
	private static final LocalTime DEFAULT_SWITCH_TIME = LocalTime.of(0, 20, 0);
	private static final LocalTime DEFAULT_START_SWITCH_TIME = LocalTime.of(0, 30, 0);
	private static final Integer DEFAULT_NUMBER_OF_PLAYER_SWITCHABLE = 1;
	private static final String DEFAULT_SWITCH_AFTER_BORDER_MOVES = "N";
	private static final String DEFAULT_REVIVE_NEAR_TEAMATE = "Y";
	private static final String DEFAULT_ONE_PLAYER_SWITCH = "N";
	private Integer numberOfPlayerSwitchable;
	private LocalTime switchTime, startSwitchTime, fractionTime, warningTime, pvpTime;
	private String switchAfterBorderMoves, reviveNearTeamate, onePlayerSwitch;

	public SwitchConfiguration(String name) {
		super(name);
		setGame(new SwitchGame(this));
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

	public String getSwitchAfterBorderMoves() {
		return switchAfterBorderMoves == null ? DEFAULT_SWITCH_AFTER_BORDER_MOVES : switchAfterBorderMoves;
	}

	@Override
	public void setSwitchAfterBorderMoves(String letter) {
		this.switchAfterBorderMoves = letter;
	}

	@Override
	public String getReviveNearTeamate() {
		return reviveNearTeamate == null ? DEFAULT_REVIVE_NEAR_TEAMATE : reviveNearTeamate;
	}

	@Override
	public void setReviveNearTeamate(String letter) {
		this.reviveNearTeamate = letter;
	}

	@Override
	public String getOnePlayerSwitch() {
		return onePlayerSwitch == null ? DEFAULT_ONE_PLAYER_SWITCH : onePlayerSwitch;
	}

	@Override
	public void setOnePlayerSwitch(String letter) {
		this.onePlayerSwitch = letter;
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
		builder.append("First switch time : " + showTime(getStartSwitchTime()) + "\n");
		builder.append("Switch every : " + showTime(getPeriodSwitchTime()) + "\n");
		builder.append("Number of players switched : " + getNumberOfPlayerSwitchable() + "\n");
		builder.append("Switch after border moves : " + getSwitchAfterBorderMoves() + "\n");
		builder.append("Revive near a teamate : " + getReviveNearTeamate() + "\n");
		builder.append("One player switch : " + getOnePlayerSwitch() + "\n");
		return builder.toString();
	}

	@Override
	public void reset() {
		super.reset();
		fractionTime = null;
		pvpTime = null;
		warningTime = null;
		startSwitchTime = null;
		switchTime = null;
		numberOfPlayerSwitchable = null;
		switchAfterBorderMoves = null;
		reviveNearTeamate = null;
		onePlayerSwitch = null;
	}

}
