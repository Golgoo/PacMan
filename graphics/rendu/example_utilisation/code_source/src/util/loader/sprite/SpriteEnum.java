package util.loader.sprite;

public class SpriteEnum {

	public enum Enum {
		FRUIT_IMAGE,
		PAC_LEFT_SPRITES,
		PAC_UP_SPRITES,
		PAC_DOWN_SPRITES,
		PAC_RIGHT_SPRITES
	}
	
	private static String spritesSheetsFolder = "ressources/spritesheets";
	
	public static String getRessourcePath(SpriteEnum.Enum ressourceEnum, String skin) {
		switch (ressourceEnum) {
		case FRUIT_IMAGE:
			return spritesSheetsFolder + "/fruits/" + skin + "/fruit.png";
		case PAC_LEFT_SPRITES:
			return spritesSheetsFolder + "/pacman/" + skin + "/pac-left.png";
		case PAC_DOWN_SPRITES:
			return spritesSheetsFolder + "/pacman/" + skin + "/pac-down.png";
		case PAC_UP_SPRITES:
			return spritesSheetsFolder + "/pacman/" + skin + "/pac-up.png" ;
		case PAC_RIGHT_SPRITES:
			return spritesSheetsFolder + "/pacman/" + skin + "/pac-right.png";
		default:
			return null;
		}
	}
}
