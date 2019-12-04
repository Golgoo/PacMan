package util.loader.font;

import java.awt.Font;

public class FontLoader {
	
	private static Font defaultFont = new Font("Verdana", Font.BOLD, 12);
	
	public static Font load(FontEnum.Enum fontEnum, float size) {
		Font font;
		try {
		    font = Font.createFont(Font.TRUETYPE_FONT, Thread.currentThread().getContextClassLoader().getResourceAsStream(FontEnum.getPath(fontEnum)));
		} catch(Exception e) {
		    e.printStackTrace() ;
		    font = defaultFont ;
		    size = size / 2 ;
		}
		font = font.deriveFont(size);
		return font ;
	}
}
