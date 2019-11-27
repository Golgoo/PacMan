package examples.KissMethod2.util;

import java.awt.Font;
import java.io.File;

public class FontLoader {
	
	private static Font defaultFont = new Font("Verdana", Font.BOLD, 24);
	
	public static Font load(String path, float size) {
		File file;
		Font font;
		try {
		    file = new File(path);
		    font = Font.createFont(Font.TRUETYPE_FONT, file);
		    font = font.deriveFont(size);
		    return font ;
		} catch(Exception ex) {
		    System.err.println(ex.getMessage());
		    font = defaultFont ;
		}
		return font ;
	}
}
