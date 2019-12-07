package fr.pederobien.uhc.dictionary.dictionaries;

import fr.pederobien.uhc.interfaces.IMessageCode;

public enum MessageCode implements IMessageCode {

	// Common messages
	DELETE_ON_CANNOT_DELETE, HELP_EXPLANATION, NEW_NAME_MUST_NOT_START_BY_DEFAULT, NEW_NAME_TAB_COMPLETE, RENAME_TAB_COMPLETE, BAD_COORDINATES_FORMAT,
	COMMAND_NOT_AVAILABLE, CANNOT_RUN_COMMAND, ARGUMENT_NOT_VALID, COMMAND_NOT_AVAILABLE_YET, BAD_TIME_FORMAT,

	// Common bawn messages
	CENTER_EXPLANATION, CENTER_DEFINED, CENTER_COORDINATES_ARE_MISSING,

	DIMENSIONS_MISSING_DIMENSIONS, DIMENSIONS_BAD_DIMENSIONS_FORMAT, DIMENSIONS_WITDH_HEIGHT_DEPTH_TAB_COMPLETE, DIMENSIONS_HEIGHT_DEPTH_TAB_COMPLETE,
	DIMENSIONS_DEPTH_TAB_COMPLETE,

	// Base messages
	BASE_EDITION_CONFIGURATION_EXPLANATION,

	CURRENT_BASE_EXPLANATION, CURRENT_BASE_MESSAGE,

	DELETE_BASE_EXPLANATION, DELETE_BASE_DELETED,

	EXTRACT_BASE_EXPLANATION, EXTRACT_BASE_ONE_CHEST_EXTRACTED, EXTRACT_BASE_CHESTS_EXTRACTED, EXTRACT_BASE_MAGENTA_WOOL_IS_FORBIDDEN,
	EXTRACT_BASE_BROWN_WOOL_HAS_NO_EQUIVALENT, EXTRACT_BASE_MATERIAL_UNDER_CHEST_IS_NOT_WOOL,

	DIMENSIONS_BASE_EXPLANATION, DIMENSIONS_BASE_DEFINED,

	LAUNCH_BASE_EXPLANATION, LAUNCH_BASE_NO_TEAM_SUPPORTED, LAUNCH_BASE_ONE_TEAM_SUPPORTED, LAUNCH_BASE_TEAMS_SUPPORTED, LAUNCH_BASE_NOT_EXISTING,
	LAUNCH_BASE_MISSING_COORDINATES, LAUNCH_BASE_MISSING_NAME_AND_COORDINATES,

	LIST_BASE_EXPLANATION, LIST_BASE_SIZE_EQUALS_0, LIST_BASE_SIZE_EQUALS_1, LIST_BASE_SIZE_GREATER_THAN_0,

	NEW_BASE_EXPLANATION, NEW_BASE_CREATED, NEW_BASE_ALREADY_EXISTING, NEW_BASE_MISSING_NAME,

	REMOVE_BASE_EXPLANATION, REMOVE_BASE_REMOVED,

	RENAME_BASE_EXPLANATION, RENAME_BASE_RENAMED, RENAME_BASE_ALREADY_EXISTING, RENAME_BASE_MISSING_NAME,

	SAVE_BASE_EXPLANATION, SAVE_BASE_SAVED,

	// Spawn messages
	SPAWN_EDITION_CONFIGURATION_EXPLANATION,

	CURRENT_SPAWN_EXPLANATION, CURRENT_SPAWN_MESSAGE,

	DELETE_SPAWN_EXPLANATION, DELETE_SPAWN_DELETED,

	EXTRACT_SPAWN_EXPLANATION, EXTRACT_SPAWN_EXTRACTED,

	DIMENSIONS_SPAWN_EXPLANATION, DIMENSIONS_SPAWN_DEFINED,

	LAUNCH_SPAWN_EXPLANATION, LAUNCH_SPAWN_LAUNCHED, LAUNCH_SPAWN_NOT_EXISTING, LAUNCH_SPAWN_MISSING_COORDINATES,
	LAUNCH_SPAWN_MISSING_NAME_AND_COORDINATES,

	LIST_SPAWN_EXPLANATION, LIST_SPAWN_SIZE_EQUALS_0, LIST_SPAWN_SIZE_EQUALS_1, LIST_SPAWN_SIZE_GREATER_THAN_0,

	NEW_SPAWN_EXPLANATION, NEW_SPAWN_CREATED, NEW_SPAWN_ALREADY_EXISTING, NEW_SPAWN_MISSING_NAME,

	RANDOM_SPAWN_EXPLANATION, RANDOM_SPAWN_LAUNCHED, RANDOM_SPAWN_CANNOT_BE_LAUNCHED, RANDOM_SPAWN_MISSING_COORDINATES,

	REMOVE_SPAWN_EXPLANATION, REMOVE_SPAWN_REMOVED,

	RENAME_SPAWN_EXPLANATION, RENAME_SPAWN_RENAMED, RENAME_SPAWN_ALREADY_EXISTING, RENAME_SPAWN_MISSING_NAME,

	SAVE_SPAWN_EXPLANATION, SAVE_SPAWN_SAVED,

	// Common style messages
	AS_CURRENT_STYLE_DEFINED,

	GAME_TIME_DEFINED, GAME_TIME_MISSING_TIME,

	LOAD_CANNOT_LOAD,

	SCOREBOARD_REFRESH_EXPLANATION, SCOREBOARD_REFRESH_NEGATIVE_TIC_DEFINED, SCOREBOARD_REFRESH_NO_TIC_DEFINED, SCOREBOARD_REFRESH_ONE_TIC_DEFINED,
	SCOREBOARD_REFRESH_TICS_DEFINED, SCOREBOARD_REFRESH_MISSING_TICS, SCOREBOARD_REFRESH_BAD_TICS_FORMAT, SCOREBOARD_REFRESH_TAB_COMPLETE,

	TEAM_EXPLANATION, TEAM_BAD_TEAM, TEAM_BAD_PLAYER, TEAM_BAD_COLOR,

	TEAM_ADDPLAYER_EXPLANATION, TEAM_ADDPLAYER_NO_PLAYER_ADDED, TEAM_ADDPLAYER_ONE_PLAYER_ADDED, TEAM_ADDPLAYER_PLAYERS_ADDED,

	TEAM_ADDTEAM_EXPLANATION, TEAM_ADDTEAM_TEAM_NO_PLAYER_ADDED, TEAM_ADDTEAM_TEAM_ONE_PLAYER_ADDED, TEAM_ADDTEAM_TEAM_PLAYERS_ADDED,
	TEAM_ADDTEAM_ALREADY_EXISTING_COLOR, TEAM_ADDTEAM_MISSING_ARGUMENTS,

	TEAM_LIST_EXPLANATION, TEAM_LIST_NO_EXISTING_TEAM, TEAM_LIST_ONE_EXISTING_TEAM, TEAM_LIST_EXISTING_TEAMS,

	TEAM_MODIFY_EXPLANATION, TEAM_MODIFY_COLOR_EXPLANATION, TEAM_MODIFY_COLOR_MODIFIED, TEAM_MODIFY_NAME_EXPLANATION, TEAM_MODIFY_NAME_MODIFIED,

	TEAM_MOVEPLAYER_EXPLANATION, TEAM_MOVEPLAYER_MOVED,

	TEAM_RANDOMTEAM_EXPLANATION, TEAM_RANDOMTEAM_DISPATCHED,

	TEAM_REMOVEPLAYER_EXPLANATION, TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED, TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED, TEAM_REMOVEPLAYER_PLAYERS_REMOVED,

	TEAM_REMOVETEAM_EXPLANATION, TEAM_REMOVETEAM_NO_TEAM_REMOVED, TEAM_REMOVETEAM_ONE_TEAM_REMOVED, TEAM_REMOVETEAM_TEAMS_REMOVED,
	TEAM_REMOVETEAM_ALL_TEAMS_REMOVED,

	// Hunger game messages
	HUNGER_GAME_EDITION_CONFIGURATION_EXPLANATION,

	AS_CURRENT_HUNGER_GAME_EXPLANATION, AS_CURRENT_HUNGER_GAME_NOT_EXISTING_STYLE,

	BORDER_CENTER_HUNGER_GAME_EXPLANATION, BORDER_CENTER_HUNGER_GAME_DEFINED, BORDER_CENTER_HUNGER_GAME_MISSING_COORDINATES,

	CURRENT_HUNGER_GAME_EXPLANATION, CURRENT_HUNGER_GAME_MESSAGE,

	DELETE_HUNGER_GAME_EXPLANATION, DELETE_HUNGER_GAME_MESSAGE,

	FINAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION, FINAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED, FINAL_BORDER_NEGATIVE_DIAMETER,
	FINAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER, FINAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT,
	FINAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE,

	FRACTION_TIME_HUNGER_GAME_EXPLANATION, FRACTION_TIME_HUNGER_GAME_DEFINED, FRACTION_TIME_HUNGER_GAME_MISSING_TIME,

	GAME_TIME_HUNGER_GAME_EXPLANATION,

	INITIAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION, INITIAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED, INITIAL_BORDER_NEGATIVE_DIAMETER,
	INITIAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER, INITIAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT,
	INITIAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE,

	LIST_HUNGER_GAME_EXPLANATION, LIST_HUNGER_GAME_SIZE_EQUALS_0, LIST_HUNGER_GAME_SIZE_EQUALS_1, LIST_HUNGER_GAME_SIZE_GREATER_THAN_0,

	LOAD_NOT_EXISTING_STYLE,

	LOAD_HUNGER_GAME_EXPLANATION, LOAD_HUNGER_GAME_STYLE_NO_TEAM_CREATED_LOADED, LOAD_HUNGER_GAME_STYLE_ONE_TEAM_CREATED_LOADED,
	LOAD_HUNGER_GAME_STYLE_TEAMS_CREATED_LOADED, LOAD_HUNGER_GAME_MISSING_NAME,

	NEW_HUNGER_GAME_EXPLANATION, NEW_HUNGER_GAME_CREATED, NEW_HUNGER_GAME_ALREADY_EXISTING, NEW_HUNGER_GAME_MISSING_NAME,

	PVP_TIME_HUNGER_GAME_EXPLANATION, PVP_TIME_HUNGER_GAME_DEFINED, PVP_TIME_HUNGER_GAME_MISSING_TIME,

	RENAME_HUNGER_GAME_EXPLANATION, RENAME_HUNGER_GAME_RENAMED, RENAME_HUNGER_GAME_ALREADY_EXISTING, RENAME_HUNGER_GAME_MISSING_NAME,

	SAVE_HUNGER_GAME_EXPLANATION, SAVE_HUNGER_GAME_SAVED,

	SPEED_BORDER_HUNGER_GAME_EXPLANATION, SPEED_BORDER_HUNGER_GAME_DEFINED, SPEED_BORDER_HUNGER_GAME_NEGATIVE, SPEED_BORDER_HUNGER_GAME_MISSING_SPEED,
	SPEED_BORDER_HUNGER_GAME_BAD_SPEED_FORMAT, SPEED_BORDER_HUNGER_GAME_TAB_COMPLETE,

	WARNING_TIME_HUNGER_GAME_EXPLANATION, WARNING_TIME_HUNGER_GAME_DEFINED, WARNING_TIME_HUNGER_GAME_MISSING_TIME,

	// On cannot run an hunger game style
	FRACTION_TIME_LESS_THAN_GAME_TIME,

	// On game messages
	TEAM_DEATH_MATCH, PVP_ALLOWED, NO_MORE_RESURRECTION, MOVING_BORDER, PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD, PLAYER_MUST_STAY_IN_THE_OVERWORLD,

	// Blockedex game messages
	BLOCKEDEX_EDITION_CONFIGURATION_EXPLANATION,

	AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION, AS_CURRENT_BLOCKEDEX_GAME_NOT_EXISTING_STYLE,

	BASE_BLOCKEDEX_GAME_EXPLANATION, BASE_BLOCKEDEX_GAME_DOES_NOT_SUPPORT_TEAM, BASE_BLOCKEDEX_GAME_MISSING_NAME,

	BASE_EAST_BLOCKEDEX_GAME_EXPLANATION, BASE_EAST_BLOCKEDEX_GAME_SETTED,

	BASE_NORTH_BLOCKEDEX_GAME_EXPLANATION, BASE_NORTH_BLOCKEDEX_GAME_SETTED,

	BASE_SOUTH_BLOCKEDEX_GAME_EXPLANATION, BASE_SOUTH_BLOCKEDEX_GAME_SETTED,

	BASE_WEST_BLOCKEDEX_GAME_EXPLANATION, BASE_WEST_BLOCKEDEX_GAME_SETTED,

	BASE_DISTANCE_BLOCKEDEX_GAME_EXPLANATION, BASE_DISTANCE_BLOCKEDEX_GAME_DEFINED, BASE_DISTANCE_BLOCKEDEX_GAME_NEGATIVE_DISTANCE,
	BASE_DISTANCE_BLOCKEDEX_GAME_MISSING_DISTANCE, BASE_DISTANCE_BLOCKEDEX_GAME_BAD_DISTANCE_FORMAT, BASE_DISTANCE_BLOCKEDEX_GAME_TAB_COMPLETE,

	CURRENT_BLOCKEDEX_GAME_EXPLANATION, CURRENT_BLOCKEDEX_GAME_MESSAGE,

	DELETE_BLOCKEDEX_GAME_EXPLANATION, DELETE_BLOCKEDEX_GAME_MESSAGE,

	GAME_TIME_BLOCKEDEX_GAME_EXPLANATION,

	LIST_BLOCKEDEX_GAME_EXPLANATION, LIST_BLOCKEDEX_GAME_SIZE_EQUALS_0, LIST_BLOCKEDEX_GAME_SIZE_EQUALS_1, LIST_BLOCKEDEX_GAME_SIZE_GREATER_THAN_0,

	LOAD_BLOCKEDEX_GAME_EXPLANATION, LOAD_BLOCKEDEX_GAME_STYLE_NO_TEAM_CREATED_LOADED, LOAD_BLOCKEDEX_GAME_STYLE_ONE_TEAM_CREATED_LOADED,
	LOAD_BLOCKEDEX_GAME_STYLE_TEAMS_CREATED_LOADED, LOAD_BLOCKEDEX_GAME_MISSING_NAME,

	NEW_BLOCKEDEX_GAME_EXPLANATION, NEW_BLOCKEDEX_GAME_CREATED, NEW_BLOCKEDEX_GAME_ALREADY_EXISTING, NEW_BLOCKEDEX_GAME_MISSING_NAME,

	RENAME_BLOCKEDEX_GAME_EXPLANATION, RENAME_BLOCKEDEX_GAME_RENAMED, RENAME_BLOCKEDEX_GAME_ALREADY_EXISTING, RENAME_BLOCKEDEX_GAME_MISSING_NAME,

	SAVE_BLOCKEDEX_GAME_EXPLANATION, SAVE_BLOCKEDEX_GAME_SAVED,

	// On cannot run an blockedex game style
	BAD_BASES_CONFIGURATION,

	// On game messages
	CHEST_IS_RESTRICTED,

	// Start messages
	PLAYERS_NOT_IN_TEAM, NO_GAME_STYLE_DEFINED_AS_CURRENT,

	// Common on game messages
	GAME_SUSPENDED, GAME_RESUMED;

	private MessagePermission permission;

	private MessageCode() {
		this(MessagePermission.OPERATORS);
	}

	private MessageCode(MessagePermission permission) {
		this.permission = permission;
	}

	@Override
	public MessagePermission getPermission() {
		return permission;
	}

	@Override
	public void setPermission(MessagePermission permission) {
		this.permission = permission;
	}
}