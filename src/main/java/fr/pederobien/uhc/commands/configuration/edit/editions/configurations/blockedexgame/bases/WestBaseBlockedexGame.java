package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

public class WestBaseBlockedexGame extends AbstractBaseEdition {

	protected WestBaseBlockedexGame() {
		super("west", "to set the base at the west of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setWestBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getWestBase() + " defined as the west base";
	}
}
