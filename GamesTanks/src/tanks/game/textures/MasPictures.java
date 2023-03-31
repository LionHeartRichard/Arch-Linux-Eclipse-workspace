package tanks.game.textures;

import java.awt.image.BufferedImage;

public class MasPictures {

	private BufferedImage pictures;
	private int countPictures;
	private int sizePicture;
	private int picturesWidth;

	public MasPictures(BufferedImage pictures, int countPictures, int sizePicture) {
		this.pictures = pictures;
		this.countPictures = countPictures;
		this.sizePicture = sizePicture;
		this.picturesWidth = pictures.getWidth() / sizePicture;
	}

	public BufferedImage getPicture(int index) {

		index = index % countPictures;
		int x = index % picturesWidth * sizePicture;
		int y = index / picturesWidth * sizePicture;

		return pictures.getSubimage(x, y, sizePicture, sizePicture);
	}
}
