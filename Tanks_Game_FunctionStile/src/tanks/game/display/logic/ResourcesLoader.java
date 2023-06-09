package tanks.game.display.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourcesLoader {

	public static final String PATH_RESOURCES = "/home/kein/eclipse-workspace/Tanks_Game_FunctionStile/resources/";

	public static BufferedImage loadImage(String filename) throws IOException {
		BufferedImage image = null;
		image = ImageIO.read(new File(PATH_RESOURCES + filename));
		return image;
	}
}
