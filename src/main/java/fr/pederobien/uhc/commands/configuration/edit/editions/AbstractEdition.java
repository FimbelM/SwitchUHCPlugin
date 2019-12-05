package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IEdition;

public abstract class AbstractEdition implements IEdition {
	private String label;
	private MessageCode explanation;

	public AbstractEdition(String label, MessageCode explanation) {
		this.label = label;
		this.explanation = explanation;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public MessageCode getExplanation() {
		return explanation;
	}
	
	protected List<String> emptyList() {
		return new ArrayList<String>();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		return list.stream().filter(str -> str.startsWith(filter)).collect(Collectors.toList());
	}

	protected List<String> filter(Stream<String> stream, String begining) {
		return stream.filter(str -> str.startsWith(begining)).collect(Collectors.toList());
	}
}
