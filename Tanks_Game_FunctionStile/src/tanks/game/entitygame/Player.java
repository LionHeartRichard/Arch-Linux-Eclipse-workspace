package tanks.game.entitygame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.HashMap;

import tanks.game.myinput.MyInput;
import tanks.game.textures.MasPictures;
import tanks.game.textures.MyPicture;
import tanks.game.textures.TextureAtlasPicteres;

public class Player extends EntityGame {

	public static final int PICTURE_SCALER = 16;
	public static final int NUMBER_OF_PICTURES = 1;

	private enum DirectionTank {
		NORTH(0 * PICTURE_SCALER, 0 * PICTURE_SCALER, 1 * PICTURE_SCALER, 1 * PICTURE_SCALER),
		SOUTH(4 * PICTURE_SCALER, 0 * PICTURE_SCALER, 1 * PICTURE_SCALER, 1 * PICTURE_SCALER),
		EAST(6 * PICTURE_SCALER, 0 * PICTURE_SCALER, 1 * PICTURE_SCALER, 1 * PICTURE_SCALER),
		WEST(2 * PICTURE_SCALER, 0 * PICTURE_SCALER, 1 * PICTURE_SCALER, 1 * PICTURE_SCALER);

		private int x, y, w, h;

		private DirectionTank(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		protected BufferedImage getTexture(TextureAtlasPicteres pictere) {
			return pictere.cut(x, y, w, h);
		}

	}

	private DirectionTank directionTank;
	private Map<DirectionTank, MyPicture> pictersMap;
	private float sizeTank;

	public Player(float x, float y, float size, TextureAtlasPicteres pictureAtlas) {
		super(EntityType.PLAYER, x, y);

		directionTank = DirectionTank.NORTH;
		pictersMap = new HashMap<DirectionTank, MyPicture>();

		this.sizeTank = sizeTank;

		for (DirectionTank d : DirectionTank.values()) {
			MasPictures masPictures = new MasPictures(d.getTexture(pictureAtlas), NUMBER_OF_PICTURES, PICTURE_SCALER);
			MyPicture picture = new MyPicture(masPictures, sizeTank);
			pictersMap.put(d, picture);
		}
	}

	@Override
	protected void update(MyInput myInput) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void render(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
