package inputs.commands;

public class CommandEnum{
	public static enum Enum{
		MOVE_UP, MOVE_DOWN, MOVE_RIGHT, MOVE_LEFT,
		PLAY_PAUSE, NEW_GAME, REDUCE_PAC, GROW_PAC
	};
	
	public static String getDescription(CommandEnum.Enum commandEnum) {
		switch (commandEnum) {
		case MOVE_UP:
			return "Aller en haut";
		case MOVE_DOWN:
			return "Aller en bas";
		case MOVE_LEFT:
			return "Aller à gauche";
		case MOVE_RIGHT:
			return "Aller à droite";
		case PLAY_PAUSE:
			return "Pause . Reprendre";
		case NEW_GAME:
			return "Nouvelle partie";
		case REDUCE_PAC:
			return "Réduire la taille pacman";
		case GROW_PAC:
			return "Agrandir pacman";
		default:
			return "";
		}
	}
	
}
