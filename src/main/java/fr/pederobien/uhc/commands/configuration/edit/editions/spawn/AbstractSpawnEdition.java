package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.block.Block;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractSpawnEdition implements IEdition {
	private SpawnEditions edition;
	private IPersistence<ISpawn> persistence;

	public AbstractSpawnEdition(IPersistence<ISpawn> persistence, SpawnEditions edition) {
		this.persistence = persistence;
		this.edition = edition;
	}

	@Override
	public String getLabel() {
		return edition.getLabel();
	}

	@Override
	public String help() {
		return edition.help();
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}

	protected IPersistence<ISpawn> getPersistence() {
		return persistence;
	}

	protected ISpawn getSpawn() {
		return persistence.get();
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}

	protected List<String> filter(List<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
