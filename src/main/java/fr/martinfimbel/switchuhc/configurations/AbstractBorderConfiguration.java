package fr.martinfimbel.switchuhc.configurations;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.interfaces.IBorderConfiguration;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class AbstractBorderConfiguration extends AbstractConfiguration implements IBorderConfiguration {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private static final Double DEFAULT_INITIAL_BORDER_SIZE = new Double(3000);
	private static final Double DEFAULT_FINAL_BORDER_SIZE = new Double(20);
	private static final Double DEFAULT_BORDER_SPEED = 1.0;

	private Block borderCenter;
	private Double initialBorderDiameter, finalBorderDiameter, borderSpeed;

	protected AbstractBorderConfiguration(String name) {
		super(name);
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
	public Double getBorderSpeed() {
		return borderSpeed == null ? DEFAULT_BORDER_SPEED : borderSpeed;
	}

	@Override
	public void setBorderSpeed(double borderSpeed) {
		this.borderSpeed = borderSpeed;
	}

}
