package tanks.game.textures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MyPicture {

	private MasPictures masPictures;
	private float scaler;

	public MyPicture(MasPictures masPictures, float scaler) {
		this.masPictures = masPictures;
		this.scaler = scaler;
	}

	public void render(Graphics2D g, float x, float y) {
		BufferedImage image = masPictures.getPicture(0);
		g.drawImage(image, (int) x, (int) y, (int) image.getWidth(), (int) image.getHeight(), null);
	}
}
