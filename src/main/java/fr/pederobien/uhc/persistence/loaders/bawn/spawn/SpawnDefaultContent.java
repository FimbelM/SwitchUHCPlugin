package fr.pederobien.uhc.persistence.loaders.bawn.spawn;

import fr.pederobien.uhc.persistence.IDefaultContent;

public class SpawnDefaultContent implements IDefaultContent {

	@Override
	public String getName() {
		return "DefaultSpawn";
	}

	@Override
	public String getDefaultXmlContent() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "  <spawn>\r\n" + "  <version>1.2</version>\r\n"
				+ "  <name>" + getName() + "</name>\r\n" + "  <dimensions width=\"5\" height=\"1\" depth=\"5\"/>\r\n"
				+ "  <center x=\"0\" y=\"90\" z=\"0\"/>\r\n" + "  <blocks>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"2\"/>\r\n" + "  </blocks>\r\n"
				+ "</spawn>";
	}
}
