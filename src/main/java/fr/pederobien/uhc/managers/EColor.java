package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;

public enum EColor {
	AQUA(ChatColor.AQUA, "aqua"), DARK_AQUA(ChatColor.DARK_AQUA, "dark_aqua"), BLUE(ChatColor.BLUE, "blue"),
	DARK_BLUE(ChatColor.DARK_BLUE, "dark_blue"), BLACK(ChatColor.BLACK, "black"), GRAY(ChatColor.GRAY, "gray"),
	DARK_GRAY(ChatColor.DARK_GRAY, "dark_gray"), GREEN(ChatColor.GREEN, "green"), DARK_GREEN(ChatColor.DARK_GREEN, "dark_green"),
	RED(ChatColor.RED, "red"), DARK_RED(ChatColor.DARK_RED, "dark_red"), GOLD(ChatColor.GOLD, "gold"), YELLOW(ChatColor.YELLOW, "yellow"),
	PINK(ChatColor.LIGHT_PURPLE, "light_purple"), PURPLE(ChatColor.DARK_PURPLE, "dark_purple"), WHITE(ChatColor.WHITE, "white");

	private static HashMap<ChatColor, EColor> mapColor = new HashMap<ChatColor, EColor>();
	private static HashMap<String, EColor> mapColorName = new HashMap<String, EColor>();
	private static List<String> colorsName = new ArrayList<String>();
	private ChatColor color;
	private String colorName;

	static {
		for (EColor color : values()) {
			mapColorName.put(color.getColorName(), color);
			colorsName.add(color.getColorName());
		}
	}

	public static EColor getByColor(ChatColor color) {
		return mapColor.get(color);
	}

	public static EColor getByColorName(String colorName) {
		return mapColorName.get(colorName);
	}

	public static List<String> getColorsName() {
		return colorsName;
	}

	public String getInColor(String toShow) {
		return this.getChatColor() + toShow + ChatColor.RESET;
	}

	private EColor(ChatColor color, String colorName) {
		this.color = color;
		this.colorName = colorName;
	}

	public ChatColor getChatColor() {
		return color;
	}

	public String getColorName() {
		return colorName;
	}

	public String getColoredColorName() {
		return getInColor(colorName);
	}
}