package util.loader.font;

public class FontEnum {
	public enum Enum{
		HEADLINE_FONT,
		PACMAN_FONT,
		KEYBOARD_FONT,
	}
	
	private static String fontPath = "ressources/fonts/";
	
	public static String getPath(FontEnum.Enum fontEnum) {
		switch (fontEnum) {
		case HEADLINE_FONT:
			return fontPath + "Headline.ttf";
		case PACMAN_FONT:
			return fontPath + "PacfontGood.ttf";
		case KEYBOARD_FONT:
			return fontPath + "key_font.otf";
		default:
			System.err.println("FONT NOT EXIST");
			return null ;
		}
	}
}
