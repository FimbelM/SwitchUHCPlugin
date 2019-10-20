package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;

public enum ETeam {
	AQUA(ChatColor.AQUA, "aqua", "Aqua"), DARK_AQUA(ChatColor.DARK_AQUA, "dark_aqua", "Dark aqua"),
	BLUE(ChatColor.BLUE, "blue", "Blue"), DARK_BLUE(ChatColor.DARK_BLUE, "dark_blue", "Dark blue"),
	BLACK(ChatColor.BLACK, "black", "Black"), GRAY(ChatColor.GRAY, "gray", "Gray"),
	DARK_GRAY(ChatColor.DARK_GRAY, "dark_gray", "Dark gray"), GREEN(ChatColor.GREEN, "green", "Green"),
	DARK_GREEN(ChatColor.DARK_GREEN, "dark_green", "Dark green"), RED(ChatColor.RED, "red", "Red"),
	DARK_RED(ChatColor.DARK_RED, "dark_red", "Dark red"), GOLD(ChatColor.GOLD, "gold", "Gold"),
	YELLOW(ChatColor.YELLOW, "yellow", "Yellow"), PINK(ChatColor.LIGHT_PURPLE, "light_purple", "Pink"),
	PURPLE(ChatColor.DARK_PURPLE, "dark_purple", "Purple"), WHITE(ChatColor.WHITE, "white", "White");

	private static HashMap<ChatColor, ETeam> mapColor = new HashMap<ChatColor, ETeam>();
	private static HashMap<String, ETeam> mapColorName = new HashMap<String, ETeam>();
	private static List<String> colorsName = new ArrayList<String>();
	private ChatColor color;
	private String colorName;
	private String name;
	private List<String> players;

	static {
		for (ETeam team : values()) {
			mapColor.put(team.getColor(), team);
			mapColorName.put(team.getColorName(), team);
			colorsName.add(team.getColorName());
		}
	}

	public static ETeam getByColor(ChatColor color) {
		return mapColor.get(color);
	}

	public static ETeam getByName(String name) {
		for (ETeam team : values())
			if (team.getNameWithoutColor().equals(name))
				return team;
		return null;
	}

	public static ETeam getByColorName(String colorName) {
		return mapColorName.get(colorName);
	}

	public static List<String> getColorsName() {
		return colorsName;
	}

	private ETeam(ChatColor color, String colorName, String name) {
		this.color = color;
		this.colorName = colorName;
		this.name = name;
		players = new ArrayList<String>();
	}

	public ChatColor getColor() {
		return color;
	}

	public String getNameWithColor() {
		return color + name + ChatColor.RESET;
	}

	public String getNameWithoutColor() {
		return name;
	}

	public String getColorName() {
		return colorName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPlayer(String... players) {
		for (String player : players)
			this.players.add(player);
	}

	public void removePlayer(String... players) {
		for (String player : players)
			this.players.remove(player);
	}

	public List<String> getPlayers() {
		return players;
	}
}