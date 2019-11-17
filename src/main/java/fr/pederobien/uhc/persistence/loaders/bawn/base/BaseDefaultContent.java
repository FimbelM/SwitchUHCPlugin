package fr.pederobien.uhc.persistence.loaders.bawn.base;

import fr.pederobien.uhc.persistence.IDefaultContent;

public class BaseDefaultContent implements IDefaultContent {
	
	@Override
	public String getName() {
		return "DefaultBase";
	}

	@Override
	public String getDefaultXmlContent() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><base>\r\n" + 
				"  <version>1.0</version>\r\n" + 
				"  <name>" + getName() + "</name>\r\n" + 
				"  <dimensions depth=\"7\" height=\"5\" width=\"7\"/>\r\n" + 
				"  <center x=\"0\" y=\"100\" z=\"0\"/>\r\n" + 
				"  <chests>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" color=\"aqua\" team=\"Aqua\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" color=\"yellow\" team=\"vikings\" x=\"0\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" color=\"dark_red\" team=\"barbaric\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" color=\"gold\" team=\"spartiate\" x=\"1\" y=\"1\" z=\"0\"/>\r\n" + 
				"  </chests>\r\n" + 
				"  <blocks>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]\" x=\"-3\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:light_blue_wool\" x=\"-1\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wool\" x=\"0\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wool\" x=\"0\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:orange_wool\" x=\"1\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]\" x=\"3\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" x=\"1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:light_blue_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:light_blue_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"-2\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"-2\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"2\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"2\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:orange_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:orange_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"3\"/>\r\n" + 
				"  </blocks>\r\n" + 
				"</base>\r\n";
	}
}
