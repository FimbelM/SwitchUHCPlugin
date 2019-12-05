package fr.pederobien.uhc.dictionary.dictionaries;

import java.util.Locale;

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_ON_CANNOT_DELETE) {
			@Override
			public String getMessage() {
				return "Impossible de supprimer " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.HELP_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher toutes les fonctionnalités";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_NAME_MUST_NOT_START_BY_DEFAULT) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " ne doit pas commencer par 'default' (insensible à la casse)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_NAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<nom>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<nouveau nom>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BAD_COORDINATES_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format des coordonnées, elles doivent être des entiers";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.COMMAND_NOT_AVAILABLE) {
			@Override
			public String getMessage() {
				return "Commande " + getCode().getArgs()[0] + " non disponible";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CANNOT_RUN_COMMAND) {
			@Override
			public String getMessage() {
				return "Impossible d'exécuter la commande " + getCode().getArgs()[0] + ", des arguments sont manquants";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.ARGUMENT_NOT_VALID) {
			@Override
			public String getMessage() {
				return "L'argument " + getCode().getArgs()[0] + " n'est pas valide";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le center";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_DEFINED) {
			@Override
			public String getMessage() {
				return "Centre défini en " + getCode().getArgs()[0] + " " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CENTER_COORDINATES_ARE_MISSING) {
			@Override
			public String getMessage() {
				return "Impossible de modifier les coordonnées du centre, il manque <X> ou <Y> ou <Z>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_MISSING_DIMENSIONS) {
			@Override
			public String getMessage() {
				return "Impossible de changer les dimensions, il manque la <largeur> ou la <hauteur> ou la <profondeur>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BAD_DIMENSIONS_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format des dimensions, elles doivent être des entiers";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_WITDH_HEIGHT_DEPTH_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<largeur> <hauteur> <profondeur>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_HEIGHT_DEPTH_TAB_COMPLETE) {

			@Override
			public String getMessage() {
				return "<hauteur> <profondeur>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_DEPTH_TAB_COMPLETE) {

			@Override
			public String getMessage() {
				return "<profondeur>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EDITION_CONFIGURATION_EXPLANATION) {

			@Override
			public String getMessage() {
				return "pour configurer une base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BASE_EXPLANATION) {

			@Override
			public String getMessage() {
				return "pour connaître le nom de la base courante";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BASE_MESSAGE) {

			@Override
			public String getMessage() {
				return "Base courante : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BASE_EXPLANATION) {

			@Override
			public String getMessage() {
				return "pour supprimer une base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BASE_DELETED) {

			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " supprimée";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour extraire du monde les blocks de la base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_ONE_CHEST_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " extraite\nUn coffre détecté pour la couleur d'équipe "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_CHESTS_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " extraites"
						+ "\nDes coffres détectés pour les couleurs d'équipes : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_MAGENTA_WOOL_IS_FORBIDDEN) {
			@Override
			public String getMessage() {
				return "L'utilisation de la laine magenta est interdite, utilisez la laine rose ou violette";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_BROWN_WOOL_HAS_NO_EQUIVALENT) {
			@Override
			public String getMessage() {
				return "La laine marron n'a pas d'équivalent dans les couleurs d'équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_BASE_MATERIAL_UNDER_CHEST_IS_NOT_WOOL) {
			@Override
			public String getMessage() {
				return "Le block en dessous d'un coffre n'est pas de laine";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour extraire du monde les blocks de la base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DIMENSIONS_BASE_DEFINED) {
			@Override
			public String getMessage() {
				return "Les dimensions de la base " + getCode().getArgs()[0] + " sont " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour charger une base dans le monde";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_NO_TEAM_SUPPORTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " chargée en " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nAucune couleur d'équipe supportée";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_ONE_TEAM_SUPPORTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " chargée en " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nUne couleur d'équipe supportée : "
						+ getCode().getArgs()[4];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_TEAMS_SUPPORTED_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " chargée en " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3] + "\nCouleurs d’équipe supportées : "
						+ getCode().getArgs()[4];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_NOT_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de charger la base " + getCode().getArgs()[0] + ", la base n’existe pas";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de charger la base " + getCode().getArgs()[0]
						+ ", il manque les coordonnées <X> ou <Y> ou <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_BASE_MISSING_NAME_AND_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de charger la base " + getCode().getArgs()[0]
						+ " il manque le nom et les coordonnées <X> ou <Y> ou <Z> du centre";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher le nom des bases existantes";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "Il n’existe aucune base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "Il existe une base : " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BASE_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "Liste des bases existantes : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour créer une nouvelle base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_CREATED) {
			@Override
			public String getMessage() {
				return "Nouvelle base " + getCode().getArgs()[0] + " créée";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Une base " + getCode().getArgs()[0] + " existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BASE_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de créer une nouvelle base, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour enlever une base du monde";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_BASE_REMOVED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " enlevée du monde";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour renommer une base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_RENAMED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " renommée : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de renommer la base " + getCode().getArgs()[0] + " en " + getCode().getArgs()[1]
						+ ", une base du même nom existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BASE_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de renommer la base " + getCode().getArgs()[0] + ", il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BASE_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour sauvegarder une base";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BASE_SAVED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " sauvegardée";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SPAWN_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour configurer un spawn";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour connaître le nom du spawn courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_SPAWN_MESSAGE) {
			@Override
			public String getMessage() {
				return "Spawn courant " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour supprimer un spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_SPAWN_DELETED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " supprimé";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour extraire du monde les blocks du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.EXTRACT_SPAWN_EXTRACTED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " extrait";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour charger un spawn dans le monde";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " chargé en " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_NOT_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de charger le spawn " + getCode().getArgs()[0] + ", le spawn n’existe pas";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de charger le spawn " + getCode().getArgs()[0]
						+ ", il manque les coordonées <X> ou <Y> ou <Z> du centre";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LAUNCH_SPAWN_MISSING_NAME_AND_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de charger le spawn " + getCode().getArgs()[0]
						+ " il manque le nom et les coordonnées <X> ou <Y> ou <Z> du centre";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher le nom des spawns existants";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "Il n’existe aucun spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "Il existe un spawn : " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_SPAWN_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "Liste des spawns existants : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour créer un nouveau spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_CREATED) {
			@Override
			public String getMessage() {
				return "Nouveau spawn " + getCode().getArgs()[0] + " créé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Un spawn " + getCode().getArgs()[0] + " existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_SPAWN_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de créer un nouveau spawn, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour charger aléatoirement un spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Le spawn " + getCode().getArgs()[0] + " est chargé en " + getCode().getArgs()[1] + " "
						+ getCode().getArgs()[2] + " " + getCode().getArgs()[3];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_CANNOT_BE_LAUNCHED) {
			@Override
			public String getMessage() {
				return "Impossible de charger le spawn " + getCode().getArgs()[0] + ", le spawn n'existe pas";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RANDOM_SPAWN_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de charger aléatoirement un spawn, il manque les coordonnées "
						+ "<X> ou <Y> ou <Z> du centre";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour enlever le spawn du monde";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.REMOVE_SPAWN_REMOVED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " enlevé du monde";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour renommer le spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_RENAMED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " renommée : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le spawn " + getCode().getArgs()[0] + " en " + getCode().getArgs()[1]
						+ ", un spawn du même nom existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_SPAWN_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le spawn " + getCode().getArgs()[0] + ", il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_SPAWN_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour sauvegarder le spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_SPAWN_SAVED) {
			@Override
			public String getMessage() {
				return "Spawn " + getCode().getArgs()[0] + " sauvegardé";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_STYLE_DEFINED) {
			@Override
			public String getMessage() {
				return "Style " + getCode().getArgs()[0] + " défini en tant que style courant";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_DEFINED) {
			@Override
			public String getMessage() {
				return "Temps de jeu défini : " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Impossible de définir le temps de jeu, il manque le temps";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format du temps, il doit respecter le schéma hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_CANNOT_LOAD) {
			@Override
			public String getMessage() {
				return "Impossible de charger le style " + getCode().getArgs()[0] + ", le style n'existe pas";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la fréquence (tics serveur) de rafraichissement du scoreboard de chaque joueur";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_NEGATIVE_TIC_DEFINED) {
			@Override
			public String getMessage() {
				return "La fréquence doit être positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_ONE_TIC_DEFINED) {
			@Override
			public String getMessage() {
				return "Le scoreboard est rafraichit à chaque tic serveur";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_TICS_DEFINED) {
			@Override
			public String getMessage() {
				return "Le scoreboard est rafraichit tous les " + getCode().getArgs()[0] + " tics";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_MISSING_TICS) {
			@Override
			public String getMessage() {
				return "Impossible de définir la fréquence de rafraichissement, il manque la fréquence";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_BAD_TICS_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format de la fréquence, elle doit être un entier";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SCOREBOARD_REFRESH_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<nombre de tic>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour gérer les équipes d'un style de jeu";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_TEAM) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " ne correspond pas à une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_PLAYER) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " ne correspond pas à un joueur";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_BAD_COLOR) {
			@Override
			public String getMessage() {
				return getCode().getArgs()[0] + " ne correspond pas à une couleur";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour ajouter un joueur à une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_NO_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Aucun joueur ajouté";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_ONE_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Joueur " + getCode().getArgs()[0] + " ajouté à l'équipe " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDPLAYER_PLAYERS_ADDED) {
			@Override
			public String getMessage() {
				return "Joueurs " + getCode().getArgs()[0] + " ajoutés à l'équipe " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour ajouter une équipe à un style";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_NO_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Equipe " + getCode().getArgs()[0] + " créée, aucun joueur ajouté";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_ONE_PLAYER_ADDED) {
			@Override
			public String getMessage() {
				return "Equipe " + getCode().getArgs()[0] + " créée, un joueur ajouté : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_TEAM_PLAYERS_ADDED) {
			@Override
			public String getMessage() {
				return "Equipe " + getCode().getArgs()[0] + " créée, joueurs ajoutés : " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_ALREADY_EXISTING_COLOR) {
			@Override
			public String getMessage() {
				return "Une équipe possède déjà cette couleur " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_ADDTEAM_MISSING_ARGUMENTS) {
			@Override
			public String getMessage() {
				return "Impossible de créer une nouvelle équipe, des arguments sont manquants";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher le nom des équipes du style de jeu";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_NO_EXISTING_TEAM) {
			@Override
			public String getMessage() {
				return "Il n'existe aucune équipe pour le style " + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_ONE_EXISTING_TEAM) {
			@Override
			public String getMessage() {
				return "Il existe une équipe :\n" + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_LIST_EXISTING_TEAMS) {
			@Override
			public String getMessage() {
				return "Liste des équipes :\n" + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour modifier les caractéristiques d'une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_COLOR_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour changer la couleur d'une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_COLOR_MODIFIED) {
			@Override
			public String getMessage() {
				return "La couleur de l'équipe " + getCode().getArgs()[0] + " a été mise à jour";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_NAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour modifier le nom d'une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MODIFY_NAME_MODIFIED) {
			@Override
			public String getMessage() {
				return "Equipe " + getCode().getArgs()[0] + " renommée en " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MOVEPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour déplacer un joueur d'une équipe à une autre équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_MOVEPLAYER_MOVED) {
			@Override
			public String getMessage() {
				return "Joueur " + getCode().getArgs()[0] + " déplacé dans l'équipe " + getCode().getArgs()[2]
						+ ", ancienne équipe " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_RANDOMTEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour répartir les joueurs dans les équipes";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_RANDOMTEAM_DISPATCHED) {
			@Override
			public String getMessage() {
				return "Equipes aléatoires créées :\n" + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour enlever un joueur d'une équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED) {
			@Override
			public String getMessage() {
				return "Aucun joueur de l'équipe " + getCode().getArgs()[0] + " n'a été enlevé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED) {
			@Override
			public String getMessage() {
				return "Joueur " + getCode().getArgs()[0] + " enlevé de l'équipe " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVEPLAYER_PLAYERS_REMOVED) {
			@Override
			public String getMessage() {
				return "Joueurs " + getCode().getArgs()[0] + " enlevé de l'équipe " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour enlever une équipe d'un style de jeu";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_NO_TEAM_REMOVED) {
			@Override
			public String getMessage() {
				return "Aucune équipe enlevée";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_ONE_TEAM_REMOVED) {
			@Override
			public String getMessage() {
				return "L'équipe " + getCode().getArgs()[0] + " a été enlevée";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_TEAMS_REMOVED) {
			@Override
			public String getMessage() {
				return "Les équipes " + getCode().getArgs()[0] + " ont été enlevées";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_REMOVETEAM_ALL_TEAMS_REMOVED) {
			@Override
			public String getMessage() {
				return "Toutes les équipes ont été enlevées";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.HUNGER_GAME_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour configurer un style de jeu hunger game";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "Pour définir le style hunger game courant comme le style courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_HUNGER_GAME_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Impossible le style hunger game " + getCode().getArgs()[0]
						+ " comme le style courant, ce style n'existe pas";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le centre de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Le centre de la bordure est défini : " + getCode().getArgs()[0] + " " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_MISSING_COORDINATES) {
			@Override
			public String getMessage() {
				return "Impossible de définir les coordonées du centre, il manque les coordonnées <X> ou <Z>";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BORDER_CENTER_HUNGER_GAME_BAD_COORDINATES_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format des coordonnées, elles doivent être des entiers";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour connaître le nom du style de jeu hunger game courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_HUNGER_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Style hunger game courant " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour supprimer un style hunger game";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_HUNGER_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Style hunger game " + getCode().getArgs()[0] + " supprimé";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "Pour définir le diamètre final de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Diamètre final défini : " + getCode().getArgs()[0] + " blocks";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_NEGATIVE_DIAMETER) {
			@Override
			public String getMessage() {
				return "Le diamètre final de la bordure doit être strictement positif";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER) {
			@Override
			public String getMessage() {
				return "Impossible de définir le diamètre final de la bordure, il manque le diamètre";
			}
		}).registerMessage(
				new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT) {
					@Override
					public String getMessage() {
						return "Mauvais format du diamètre, il doit être un entier";
					}
				})
				.registerMessage(new AbstractPlayerMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE) {
					@Override
					public String getMessage() {
						return "<diamètre final>";
					}
				});

		registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le temps au bout duquel les joueurs réapparaîtront en mode spectateur";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Les joueur réapparaîtront en mode spectateur au bout de " + getCode().getArgs()[0] + "h "
						+ getCode().getArgs()[1] + "m " + getCode().getArgs()[2] + "s of play";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Impossible de définir le fraction time, il manque le temps";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format du temps, il doit respecter le schéma hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_DEFINED) {
			@Override
			public String getMessage() {
				return "Temps de jeu : " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Impossible de définir le temps de jeu, il manque le temps";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format du temps, il doit respecter le format hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le temps à partir duquel la bordure se déplacera de son diamètre initial à son diamètre final";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le diamètre initial de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Diamètre initial de la bordure défini : " + getCode().getArgs()[0] + " blocs";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_NEGATIVE_DIAMETER) {
			@Override
			public String getMessage() {
				return "Le diamètre initial doit être strictement positif";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER) {
			@Override
			public String getMessage() {
				return "Impossible de définir le diamètre initial, il manque le diamètre";
			}
		}).registerMessage(
				new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT) {
					@Override
					public String getMessage() {
						return "Impossible de définir le diamètre initial, il doit être un entier";
					}
				}).registerMessage(
						new AbstractPlayerMessage(MessageCode.INITIAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE) {
							@Override
							public String getMessage() {
								return "<diamètre initial>";
							}
						});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher le nom des styles hunger game existant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "Il n'existe aucun style de jeu hunger game";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "Il existe un style de jeu hunger game :\n" + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_HUNGER_GAME_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "Liste des styles de jeu hunger game existant :\n" + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Impossible de charger le style de jeu hunger game " + getCode().getArgs()[0]
						+ ", ce style n'existe pas";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour charger un style de jeu hunger game";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_NO_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style hunger game " + getCode().getArgs()[0] + " chargé\nAucune équipe créées";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_ONE_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style hunger game " + getCode().getArgs()[0] + " chargé\nUne équipe créée "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_STYLE_TEAMS_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style hunger game " + getCode().getArgs()[0] + " chargé\nEquipes créées : "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de charger un style hunger game, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour créer un nouveau style de jeu hunger game";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_CREATED) {
			@Override
			public String getMessage() {
				return "Nouveau style hunger game " + getCode().getArgs()[0] + " créé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Un style hunger game " + getCode().getArgs()[0] + " existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de créer un nouveau style hunger game, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le temps au bout duquel le pvp est autorisé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Le pvp est autorisé après " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + " de jeu";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Impossible de définir le pvp time, il manque le temps";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format du temps, il doit respecter le schéma hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour le changer le nom du style hunger game courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_RENAMED) {
			@Override
			public String getMessage() {
				return "Le style hunger game " + getCode().getArgs()[0] + " a été renommé en " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le style hunger game " + getCode().getArgs()[0] + " en "
						+ getCode().getArgs()[1] + ", ce style existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_HUNGER_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le style hunger game " + getCode().getArgs()[0] + ", il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour sauvegarder le style hunger game courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_HUNGER_GAME_SAVED) {
			@Override
			public String getMessage() {
				return "Le style hunger game " + getCode().getArgs()[0] + " a été enregistré";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la vitesse de déplacement de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "la vitesse de la bordure est défini à " + getCode().getArgs()[0] + " blocs/secondes";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_NEGATIVE) {
			@Override
			public String getMessage() {
				return "la vitesse de déplacement de la bordure doit être strictement positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_MISSING_SPEED) {
			@Override
			public String getMessage() {
				return "Impossible de définir la vitesse de déplacement de la bordure, il manque la vitesse";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_BAD_SPEED_FORMAT) {
			@Override
			public String getMessage() {
				return "La valeur de la vitesse doit être un nombre";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_TAB_COMPLETE) {
			@Override
			public String getMessage() {
				return "<blocs par seconde>";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour prévenir les joueurs qui sont dans le Nether / End de retourner à la "
						+ "surface avant le déplacement de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Les joueurs seront prévenu " + getCode().getArgs()[0] + "h " + getCode().getArgs()[1] + "m "
						+ getCode().getArgs()[2] + "s avant le déplacement de la bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_MISSING_TIME) {
			@Override
			public String getMessage() {
				return "Impossible de définir le warning time, il manque le temps";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.WARNING_TIME_HUNGER_GAME_BAD_TIME_FORMAT) {
			@Override
			public String getMessage() {
				return "Mauvais format du temps, il doit respecter le schéma hh:mm:ss";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.FRACTION_TIME_LESS_THAN_GAME_TIME) {
			@Override
			public String getMessage() {
				return "le fraction time doit être inférieur au game time";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.TEAM_DEATH_MATCH) {
			@Override
			public String getMessage() {
				return "Match à mort par équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PVP_ALLOWED) {
			@Override
			public String getMessage() {
				return "PVP autorisé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NO_MORE_RESURRECTION) {
			@Override
			public String getMessage() {
				return "Plus de résurrection";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.MOVING_BORDER) {
			@Override
			public String getMessage() {
				return "Déplacement bordure";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD) {
			@Override
			public String getMessage() {
				return "Retourner à la surface ou vous allez mourrir dans " + getCode().getArgs()[0] + "h "
						+ getCode().getArgs()[0] + "m " + getCode().getArgs()[0] + "s";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.PLAYER_MUST_STAY_IN_THE_OVERWORLD) {
			@Override
			public String getMessage() {
				return "Vous ne pouvez pas entrer dans le " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BLOCKEDEX_EDITION_CONFIGURATION_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour configurer un style de jeu blockedex";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le style blockedex courant comme style courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_NOT_EXISTING_STYLE) {
			@Override
			public String getMessage() {
				return "Impossible de charger le style " + getCode().getArgs()[0] + ", ce style n'existe pas";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir les bases d'un style de jeu blockedex";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_DOES_NOT_SUPPORT_TEAM) {
			@Override
			public String getMessage() {
				return "La base " + getCode().getArgs()[0] + " ne supporte pas toutes les équipes (nombre ou couleur)";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de définir la base, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EAST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la base située à l'Est du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_EAST_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " définie en tant que base de l'Est";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_NORTH_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la base située au Nord du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_NORTH_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " définie en tant que base du Nord";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la base située au Sud du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " définie en tant que base du Sud";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_WEST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la base située à l'Ouest du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_WEST_BLOCKEDEX_GAME_SETTED) {
			@Override
			public String getMessage() {
				return "Base " + getCode().getArgs()[0] + " définie en tant que base de l'Ouest";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir la distance entre le centre de chaque base et le centre du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_DEFINED) {
			@Override
			public String getMessage() {
				return "Chaque base est à une distance de " + getCode().getArgs()[0] + " blocks du spawn";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_NEGATIVE_DISTANCE) {
			@Override
			public String getMessage() {
				return "La distance doit être positive";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_MISSING_DISTANCE) {
			@Override
			public String getMessage() {
				return "Impossible de définir la distance, il manque la distance";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.BASE_DISTANCE_BLOCKEDEX_GAME_BAD_DISTANCE_FORMAT) {
			@Override
			public String getMessage() {
				return "Impossible de définir la distance, elle doit être un entier";
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
				return "pour connaître le nom du style de jeu blockedex courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.CURRENT_BLOCKEDEX_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex courant : " + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour supprimer un style de jeu blockedex";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.DELETE_BLOCKEDEX_GAME_MESSAGE) {
			@Override
			public String getMessage() {
				return "Style blockedex " + getCode().getArgs()[0] + " supprimé";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_TIME_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour définir le temps au bout duquel la partie s'arrête";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour afficher le nom de tous le(s) style(s) de jeu blockedex existants";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_EQUALS_0) {
			@Override
			public String getMessage() {
				return "Il n'existe aucun style de jeu blockedex";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_EQUALS_1) {
			@Override
			public String getMessage() {
				return "Il existe un style de jeu blockedex :\n" + getCode().getArgs()[0];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LIST_BLOCKEDEX_GAME_SIZE_GREATER_THAN_0) {
			@Override
			public String getMessage() {
				return "Liste des styles de jeu blockedex :\n" + getCode().getArgs()[0];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour charger un style de jeu blockedex";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_NO_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex " + getCode().getArgs()[0] + " chargé\nAucune équipe créées";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_ONE_TEAM_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex " + getCode().getArgs()[0] + " chargé\nL'équipe "
						+ getCode().getArgs()[1] + " a été créée";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_TEAMS_CREATED_LOADED) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex " + getCode().getArgs()[0] + " chargé\nEquipes créées : "
						+ getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.LOAD_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de charger le style de jeu blockedex, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour créer un nouveau style de jeu blockedex";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_CREATED) {
			@Override
			public String getMessage() {
				return "Nouveau style de jeu blockedex " + getCode().getArgs()[0] + " créé";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Le style de jeu blockedex " + getCode().getArgs()[0] + " existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NEW_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de créer un nouveau style de jeu blockedex, il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour changer le nom du style de jeu blockedex courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_RENAMED) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex " + getCode().getArgs()[0] + " renamed as " + getCode().getArgs()[1];
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_ALREADY_EXISTING) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le style de jeu blockedex " + getCode().getArgs()[0] + " en "
						+ getCode().getArgs()[1] + ", ce style existe déjà";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.RENAME_BLOCKEDEX_GAME_MISSING_NAME) {
			@Override
			public String getMessage() {
				return "Impossible de renommer le style de jeu blockedex " + getCode().getArgs()[0]
						+ ", il manque le nom";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BLOCKEDEX_GAME_EXPLANATION) {
			@Override
			public String getMessage() {
				return "pour sauvegarder le style de jeu blockedex courant";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.SAVE_BLOCKEDEX_GAME_SAVED) {
			@Override
			public String getMessage() {
				return "Style de jeu blockedex " + getCode().getArgs()[0] + " sauvegardé";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.BAD_BASES_CONFIGURATION) {
			@Override
			public String getMessage() {
				return "Une ou plusieurs bases (nord, sud, est, ouest) ne sont pas définies ou ne sont pas accessibles par rapport aux équipes enregistrées";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.CHEST_IS_RESTRICTED) {
			@Override
			public String getMessage() {
				return "Ce coffre est reservé à l'équipe" + getCode().getArgs()[0] + " vous êtes dans l'équipe " + getCode().getArgs()[1];
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.PLAYERS_NOT_IN_TEAM) {
			@Override
			public String getMessage() {
				return "Il y a des joueurs qui ne sont pas en équipe";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.NO_GAME_STYLE_DEFINED_AS_CURRENT) {
			@Override
			public String getMessage() {
				return "Aucun style de jeu défini";
			}
		});

		registerMessage(new AbstractPlayerMessage(MessageCode.GAME_SUSPENDED) {
			@Override
			public String getMessage() {
				return "Partie suspendue";
			}
		}).registerMessage(new AbstractPlayerMessage(MessageCode.GAME_RESUMED) {
			@Override
			public String getMessage() {
				return "Partie reprise";
			}
		});
	}
}
