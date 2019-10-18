package fr.pederobien.uhc.managers;

import java.util.HashMap;

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

	private ChatColor color;
	private String colorName;
	private String displayName;
	private static HashMap<ChatColor, ETeam> map = new HashMap<ChatColor, ETeam>();

	static {
		for (ETeam team : values())
			map.put(team.getColor(), team);
	}

	public static ETeam getByColor(ChatColor color) {
		return map.get(color);
	}

	private ETeam(ChatColor color, String colorName, String displayName) {
		this.color = color;
		this.colorName = colorName;
		this.displayName = displayName;
	}

	public ChatColor getColor() {
		return color;
	}

	public String getDisplayNameWithColor() {
		return color + displayName;
	}
	
	public String getDisplayNameWithoutColor() {
		return displayName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}