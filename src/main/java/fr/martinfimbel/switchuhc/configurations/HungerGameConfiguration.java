package fr.martinfimbel.switchuhc.configurations;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.game.hungergame.HungerGame;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class HungerGameConfiguration extends AbstractBorderConfiguration implements IHungerGameConfiguration {
	private static final LocalTime DEFAULT_FRACTION_TIME = LocalTime.of(0, 45, 0);
	private static final LocalTime DEFAULT_WARNING_TIME = LocalTime.of(0, 5, 0);
	private static final LocalTime DEFAULT_PVP_TIME = LocalTime.of(0, 0, 0);
	private LocalTime fractionTime, warningTime, pvpTime;

	public HungerGameConfiguration(String name) {
		super(name);
		setGame(new HungerGame(this));
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
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Border center : " + showBlock(getBorderCenter()) + "\n");
		builder.append("Initial border diameter : " + getInitialBorderDiameter() + " blocks\n");
		builder.append("Final border diameter : " + getFinalBorderDiameter() + " blocks\n");
		builder.append("Fraction time : " + showTime(getFractionTime()) + "\n");
		builder.append("Warning time : " + showTime(getWarningTime()) + "\n");
		builder.append("Pvp time : " + showTime(getPvpTime()) + "\n");
		builder.append("Border speed : " + getBorderSpeed() + " blocks/s\n");
		return builder.toString();
	}

	@Override
	public void reset() {
		super.reset();
		fractionTime = null;
		pvpTime = null;
		warningTime = null;
	}
}
