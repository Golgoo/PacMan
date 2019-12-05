package util.loader.sprite;

import java.io.InputStream;

public class SpriteLoader {
	public static InputStream getRessourceStream(SpriteEnum.Enum ressourceEnum, String skin) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(SpriteEnum.getRessourcePath(ressourceEnum, skin));
	}
}
