package fr.pederobien.uhc.dictionary.dictionaries;

import java.util.Locale;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_ON_CANNOT_DELETE) {
			@Override
			public String getMessage() {
				return "Cannot delete " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.HELP_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to displayer all features";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_NAME_MUST_NOT_START_BY_DEFAULT) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " must not start with default (ignoring case)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_NAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<name>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<newname>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BAD_COORDINATES_FORMAT) {
			@Override
			public String getMessage() {
				return "Bad coordinates format, they should be integer";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.COMMAND_NOT_AVAILABLE) {
			@Override
			public String getMessage() {
				return "Command " + getCode().getArgs()[0] + " is not available";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CANNOT_RUN_COMMAND) {
			@Override
			public String getMessage() {
				return "Cannot run command " + getCode().getArgs()[0] + ", arguments are missing";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.ARGUMENT_NOT_VALID) {
			@Override
			public String getMessage() {
				return "Argument " + getCode().getArgs()[0] + " is not a valid argument";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.COMMAND_NOT_AVAILABLE_YET) {
			@Override
			public String getMessage() {
				return "Command " + getCode().getArgs()[0] + " not available yet";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the center";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_DEFINED) {
			@Override
			public String getMessage() {
				return "Center defined in " + getCode().getArgs()[0] + " " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_COORDINATES_ARE_MISSING) {
			@Override
			public String getMessage() {
				return "Cannot set center’s coordinates, need <X> <Y> <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_BAD_COORDINATES_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse X or Y or Z coordinate";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_MISSING_DIMENSIONS) {
			@Override
			public String getMessage() {
				return "Cannot change dimensions, need <width> <height> <depth>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BAD_DIMENSIONS_FORMAT) {
			@Override
			public String getMessage() {
				return "Bad dimensions coordinates, they should be integer";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_WITDH_HEIGHT_DEPTH_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "Cannot parse width or height or depth";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_HEIGHT_DEPTH_TAB_COMPLETE) {

			@Override
			public String getMessage() {
				return "<height> <depth>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_DEPTH_TAB_COMPLETE) {

			@Override
			public String getMessage() {
				return "<depth>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BAD_COORDINATES_FORMAT) {

			@Override
			public String getMessage() {
				return "Cannot parse center’s coodinates";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EDITION_CONFIGURATION_EXPLANATION) {

			@Override
			public String getMessage() {
				return "to configure a base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BASE_EXPLANATION) {

			@Override
			public String getMessage() {
				return "to know the current base's name";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BASE_MESSAGE) {

			@Override
			public String getMessage() {
				return "Current base " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BASE_EXPLANATION) {

			@Override
			public String getMessage() {
				return "to delete a base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BASE_DELETED) {

			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " deleted";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to extract from the world the blocks of the base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_ONE_CHEST_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " extracted\nOne chest for " + getCode().getArgs()[1]
						+ " team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_CHESTS_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " extracted\nChests for teams : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_MAGENTA_WOOL_IS_FORBIDDEN) {
			@Override
			public String getMessage() {
				return "Usage of magenta wool is forbidden, please use pink or purple wool";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_BROWN_WOOL_HAS_NO_EQUIVALENT) {
			@Override
			public String getMessage() {
				return "Brown wool as no equivalent in team's color";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_MATERIAL_UNDER_CHEST_IS_NOT_WOOL) {
			@Override
			public String getMessage() {
				return "The block under chest is not wool";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to extract from the world the blocks of the base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BASE_DEFINED) {
			@Override
			public String getMessage() {
				return "Dimensions of the base " + getCode().getArgs()[0] + " defined as " + getCode().getArgs()[1]
						+ " " + getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to launch a base in the world";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_NO_TEAM_SUPPORTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " launched at " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nNo team color supported";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_ONE_TEAM_SUPPORTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " launched at " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nOne team color supported : "
						+ getCode().getArgs()[4];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_TEAMS_SUPPORTED_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " launched at " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nTeam colors supported : "
						+ getCode().getArgs()[4];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_NOT_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot launch base " + getCode().getArgs()[0] + ", base does not exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot launch base " + getCode().getArgs()[0] + ", need center’s coordinates <X> <Y> <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_MISSING_NAME_AND_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot launch base " + getCode().getArgs()[0]
						+ " need the base’s name and center’s coordinates <X> <Y> <Z>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to display all existing base(s)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "No existing base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "One existing base : " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "List of existing bases : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to create a new base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_CREATED) {
			@Override
			public String getMessage() {
				return "New base " + getCode().getArgs()[0] + " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "The base " + getCode().getArgs()[0] + " already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot create a new base, need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to remove the base from the world";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_BASE_REMOVED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " removed from the world";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to rename the base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_RENAMED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot rename base " + getCode().getArgs()[0] + " as " + getCode().getArgs()[1]
						+ ", base already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot rename the base " + getCode().getArgs()[0] + ", need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to save a base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BASE_SAVED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " saved";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.SPAWN_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to configure a spawn";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to know the current spawn’s name";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_SPAWN_MESSAGE) {
			@Override
			public String getMessage() {
				return "Current spawn " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to delete a spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_SPAWN_DELETED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " deleted";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to extract from the world the blocks of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_SPAWN_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " extracted";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to extract from the world the blocks of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BASE_DEFINED) {
			@Override
			public String getMessage() {
				return "Dimensions of the spawn " + getCode().getArgs()[0] + " defined as " + getCode().getArgs()[1]
						+ " " + getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to launch a spawn in the world";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " launched at " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_NOT_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot launch spawn " + getCode().getArgs()[0] + ", spawn does not exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot launch spawn " + getCode().getArgs()[0] + ", need center’s coordinates <X> <Y> <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_MISSING_NAME_AND_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot launch spawn " + getCode().getArgs()[0]
						+ " need the spawn’s name and center’s coordinates <X> <Y> <Z>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to display all existing spawn(s)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "No existing spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "One existing spawn : " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "List of existing spawns : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to create a new spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_CREATED) {
			@Override
			public String getMessage() {
				return "New spawn " + getCode().getArgs()[0] + " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "The spawn " + getCode().getArgs()[0] + " already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot create a new spawn, need the name";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to load randomly a spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " launched at " + getCode().getArgs()[1] + " " + getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_CANNOT_BE_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Cannot launch randomly spawn " + getCode().getArgs()[0] + ", spawn does not exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot launch randomly a spawn, need center's coordinates <X> <Y> <Z>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to remove the spawn from the world";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_SPAWN_REMOVED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " removed from the world";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to rename the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_RENAMED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot rename spawn " + getCode().getArgs()[0] + " as " + getCode().getArgs()[1]
						+ ", spawn already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot rename the spawn " + getCode().getArgs()[0] + ", need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to save a spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_SPAWN_SAVED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " saved";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_STYLE_DEFINED) {
			@Override
			public String getMessage() {
				return "Style " + getCode().getArgs()[0] + " defined as current style";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_DEFINED) {
			@Override
			public String getMessage() {
				return "Game time defined : " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Cannot set the game time, need the time";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot set the game time, wrong format, the format should be hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_CANNOT_LOAD) {
			@Override
			public String getMessage() {
				return "Cannot load style " + getCode().getArgs()[0] + ", style does not existing";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set number of server’s tic after which the scoreboard of each player is refreshed";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_NEGATIVE_TIC_DEFINED) {
			@Override
			public String getMessage() {
				return "The number of tic must be strictly positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_ONE_TIC_DEFINED) {
			@Override
			public String getMessage() {
				return "Scoreboard refreshed each tic";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_TICS_DEFINED) {
			@Override
			public String getMessage() {
				return "Scoreboard refreshed each " + getCode().getArgs()[0] + " tics";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_MISSING_TICS) {
			@Override
			public String getMessage() {
				return "Cannot set the scoreboard refresh value, need a number of tics";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_BAD_TICS_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse number of tics, the value must be an integer";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<number of tics>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to manage team for game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_TEAM) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " does not correspond to a team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_PLAYER) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " does not correspond to a player";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_COLOR) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " does not correspond to a color";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to add players into a team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_NO_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "No players added";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_ONE_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Player " + getCode().getArgs()[0] + " added to " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_PLAYERS_ADDED) {
			@Override
			public String getMessage() {
				return "Players " + getCode().getArgs()[0] + " added to " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to add a team to a style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_NO_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Team " + getCode().getArgs()[0] + " created, no player added";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_ONE_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Team " + getCode().getArgs()[0] + " created, one player added " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_PLAYERS_ADDED) {
			@Override
			public String getMessage() {
				return "Team " + getCode().getArgs()[0] + " created, players added " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_ALREADY_EXISTING_COLOR) {
			@Override
			public String getMessage() {
				return "A team as already the color " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_MISSING_ARGUMENTS) {
			@Override
			public String getMessage() {
				return "Cannot create a new team, arguments are missing";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to display all existing team(s) for a style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_NO_EXISTING_TEAM) {
			@Override
			public String getMessage() {
				return "No existing team for " + getCode().getArgs()[0] + " style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_ONE_EXISTING_TEAM) {
			@Override
			public String getMessage() {
				return "One Existing team for style " + getCode().getArgs()[0] + " :\n" + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_EXISTING_TEAMS) {
			@Override
			public String getMessage() {
				return "List of existing teams for style " + getCode().getArgs()[0] + " :\n" + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to modify teams characteristics";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_COLOR_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to change the color of a team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_COLOR_MODIFIED) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + "'s color updated";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_NAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to modify the name of a team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_NAME_MODIFIED) {
			@Override
			public String getMessage() {
				return "Team " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MOVEPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to move a player from its initial to another team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MOVEPLAYER_MOVED) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " moved from " + getCode().getArgs()[1] + " to "
						+ getCode().getArgs()[2];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_RANDOMTEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to dispatch players randomly in teams";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_RANDOMTEAM_DISPATCHED) {
			@Override
			public String getMessage() {
				return "Random teams created :\n" + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to remove a player from a team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED) {
			@Override
			public String getMessage() {
				return "No player removed from " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED) {
			@Override
			public String getMessage() {
				return "Player " + getCode().getArgs()[0] + " removed from " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_PLAYERS_REMOVED) {
			@Override
			public String getMessage() {
				return "Players " + getCode().getArgs()[0] + " removed from " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to remove a team from a game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_NO_TEAM_REMOVED) {
			@Override
			public String getMessage() {
				return "No team removed";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_ONE_TEAM_REMOVED) {
			@Override
			public String getMessage() {
				return "Team " + getCode().getArgs()[0] + " removed";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_TEAMS_REMOVED) {
			@Override
			public String getMessage() {
				return "Teams " + getCode().getArgs()[0] + " removed";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_ALL_TEAMS_REMOVED) {
			@Override
			public String getMessage() {
				return "All teams have been removed";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.HUNGER_GAME_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to configure an hunger game style";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the current hunger game style as the current style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_HUNGER_GAME_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Cannot set the hunger game style " + getCode().getArgs()[0]
						+ " as the current style, style does not exist";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the center of the world’s border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Border center defined in : " + getCode().getArgs()[0] + " " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Cannot set the border center, need coordinates <X> <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_BAD_COORDINATES_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse <X> or <Z> coordinate";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to know the name of the current hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_HUNGER_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Current hunger game style " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to delete an hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_HUNGER_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " deleted";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the final border diameter of the world’s border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Final border diameter defined as " + getCode().getArgs()[0] + " blocks";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_NEGATIVE_DIAMETER) {
			@Override
			public String getMessage() {
				return "The final border diameter should be strictly positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER) {
			@Override
			public String getMessage() {
				return "Cannot set the final border diameter, need the diameter";
			}
		}).registerMessage(
				new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT) {
					@Override
					public String getMessage() {
						return "Cannot parse final diameter";
					}
				})
				.registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE) {
					@Override
					public String getMessage() {
						return "<final diameter>";
					}
				});

		registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the time after which player will not respawn in survival mode";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Player will respawn in spectator mode after " + getCode().getArgs()[0] + "h "
						+ getCode().getArgs()[1] + "m " + getCode().getArgs()[2] + "s of play";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Cannot set the fraction time, need the time";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse the time, the format should be hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_DEFINED) {
			@Override
			public String getMessage() {
				return "Game time defined : " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Cannot set the game time, need the time";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse the time, the format should be hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the time after which the world border move from its initial diameter to its final diameter";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the initial border diameter of the world’s border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Initial border diameter defined as " + getCode().getArgs()[0] + " blocks";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_NEGATIVE_DIAMETER) {
			@Override
			public String getMessage() {
				return "The initial border diameter should be strictly positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER) {
			@Override
			public String getMessage() {
				return "Cannot set the initial border diameter, need the diameter";
			}
		}).registerMessage(
				new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT) {
					@Override
					public String getMessage() {
						return "Cannot parse initial diameter";
					}
				}).registerMessage(
						new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE) {
							@Override
							public String getMessage() {
								return "<initial diameter>";
							}
						});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to display all existing hunger game style(s)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "No existing hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "One existing hunger game style :\n" + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "Existing hunger game styles :\n" + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Cannot load style " + getCode().getArgs()[0] + ", style does not exist";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to load an hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_NO_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " loaded\nNo team created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_ONE_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " loaded\nTeam " + getCode().getArgs()[1]
						+ " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_TEAMS_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " loaded\nTeam created : "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot load hunger game style, need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to create a new hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_CREATED) {
			@Override
			public String getMessage() {
				return "New hunger game style " + getCode().getArgs()[0] + " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "The hunger game style " + getCode().getArgs()[0] + " already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot create a new hunger game style, need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the time after which pvp is authorized";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Pvp is authorized after " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s of play";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Cannot set the pvp time, need the time";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse the time, the format should be hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to change the name of the current hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_RENAMED) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot rename the hunger game style " + getCode().getArgs()[0] + " as " + getCode().getArgs()[1]
						+ ", style already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot rename the hunger game style " + getCode().getArgs()[0] + ", need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to save the current hunger game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_HUNGER_GAME_SAVED) {
			@Override
			public String getMessage() {
				return "Hunger game style " + getCode().getArgs()[0] + " saved";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to change the border’s speed when it’s moving";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "The border’s speed defined as " + getCode().getArgs()[0] + " blocks/seconds";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_NEGATIVE) {
			@Override
			public String getMessage() {
				return "The border’s speed must be strictly positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_MISSING_SPEED) {
			@Override
			public String getMessage() {
				return "Cannot set the border's speed, need the speed";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_BAD_SPEED_FORMAT) {
			@Override
			public String getMessage() {
				return "The speed must be a double value (example : 1.5)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<blocks per seconds>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "To warn players who are in the Nether / End to return to the Overworld before moving the border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Warning players " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s before moving border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Cannot set the warning time, need the time";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot parse the time, the format should be hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_LESS_THAN_GAME_TIME) {
			@Override
			public String getMessage() {
				return "The fraction time must be less than the game time";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_DEATH_MATCH) {
			@Override
			public String getMessage() {
				return "Team deatch match";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_ALLOWED) {
			@Override
			public String getMessage() {
				return "PVP auhtorized";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NO_MORE_RESURRECTION) {
			@Override
			public String getMessage() {
				return "No more resurrection";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.MOVING_BORDER) {
			@Override
			public String getMessage() {
				return "Moving border";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD) {
			@Override
			public String getMessage() {
				return "Go back to the overworld or you will die in " + getCode().getArgs()[0] + "h "
						+ getCode().getArgs()[0] + "m " + getCode().getArgs()[0] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PLAYER_MUST_STAY_IN_THE_OVERWORLD) {
			@Override
			public String getMessage() {
				return "You cannot go into the " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BLOCKEDEX_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to configure a blockedex game style";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the current blockedex game style as the current style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Cannot load blockedex game style, style does not exist";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set bases of a blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_DOES_NOT_SUPPORT_TEAM) {
			@Override
			public String getMessage() {
				return "Base does not support all team (number or color)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot set the base, need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EAST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the base at the east of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EAST_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " defined as the east base";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_NORTH_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the base at the north of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_NORTH_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " defined as the north base";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the base at the south of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " defined as the south base";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_WEST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the base at the west of the spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_WEST_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " defined as the west base";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the distance between each base’s center and spawn’s center";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Base - spawn distance defined as " + getCode().getArgs()[0] + " blocks";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_NEGATIVE_DISTANCE) {
			@Override
			public String getMessage() {
				return "The distance should be positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_MISSING_DISTANCE) {
			@Override
			public String getMessage() {
				return "Cannot set the distance, need the distance";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_BAD_DISTANCE_FORMAT) {
			@Override
			public String getMessage() {
				return "Cannot set the distance, the distance should be an integer";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<distance>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to know the name of the current blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BLOCKEDEX_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Current blockedex game style " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to delete a blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BLOCKEDEX_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Blockedex style " + getCode().getArgs()[0] + " deleted";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to set the time after which the game stops";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to display all existing blockedex game style(s)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "No existing blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "One existing blockedex game style :\n" + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "List of existing blockedex game styles :\n" + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to load an blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_NO_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Blockedex game style " + getCode().getArgs()[0] + " loaded\nNo team created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_ONE_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Blockedex game style " + getCode().getArgs()[0] + " loaded\nTeam " + getCode().getArgs()[1]
						+ " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_TEAMS_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Blockedex game style " + getCode().getArgs()[0] + " loaded\nTeam created : "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot load blockedex game style, need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to create a new blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_CREATED) {
			@Override
			public String getMessage() {
				return "New blockedex game style " + getCode().getArgs()[0] + " created";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "The blockedex game style " + getCode().getArgs()[0] + " already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot create a new blockedex game style, need the name";
			}
		});
		
		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to change the name of the current blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_RENAMED) {
			@Override
			public String getMessage() {
				return "Blockedex game style " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Cannot rename the blockedex game style " + getCode().getArgs()[0] + " as " + getCode().getArgs()[1]
						+ ", style already exist";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Cannot rename the blockedex game style " + getCode().getArgs()[0] + ", need the name";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "to save the current blockedex game style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BLOCKEDEX_GAME_SAVED) {
			@Override
			public String getMessage() {
				return "Blockedex game style " + getCode().getArgs()[0] + " saved";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BAD_BASES_CONFIGURATION) {
			@Override
			public String getMessage() {
				return "One or more bases (north, south, west, east) are not defined or not available compared to registered teams";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CHEST_IS_RESTRICTED) {
			@Override
			public String getMessage() {
				return "This chest is reserved for team " + getCode().getArgs()[0] + " you are in team "
						+ getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.PLAYERS_NOT_IN_TEAM) {
			@Override
			public String getMessage() {
				return "They are players that are not in team";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NO_GAME_STYLE_DEFINED_AS_CURRENT) {
			@Override
			public String getMessage() {
				return "No game to be launch";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_SUSPENDED) {
			@Override
			public String getMessage() {
				return "Game suspended";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_RESUMED) {
			@Override
			public String getMessage() {
				return "Game resumed";
			}
		});
	}
}
