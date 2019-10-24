package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

public class EastBaseBlockedexGame extends AbstractBaseEdition {

	protected EastBaseBlockedexGame() {
		super("east", "to set the base at the east of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setEastBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getEastBase() + " defined as the east base";
	}
}
