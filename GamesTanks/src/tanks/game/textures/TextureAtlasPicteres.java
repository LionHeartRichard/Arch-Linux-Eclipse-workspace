package tanks.game.textures;

import java.awt.image.BufferedImage;
import java.io.IOException;

import tanks.game.display.logic.ResourcesLoader;

public class TextureAtlasPicteres {
	BufferedImage image;

	public TextureAtlasPicteres(String imageName) throws IOException {
		image = ResourcesLoader.loadImage(imageName);
	}

	public BufferedImage cut(int x, int y, int w, int h) {
		return image.getSubimage(x, y, w, h);
	}
}
