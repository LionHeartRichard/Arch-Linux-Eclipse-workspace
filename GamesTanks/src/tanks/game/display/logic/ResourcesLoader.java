package tanks.game.display.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesLoader {
	public static final String PATH = "/home/kein/eclipse-workspace/GamesTanks/resources/";

	public static BufferedImage loadImage(String fileName) {

		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(PATH + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}
