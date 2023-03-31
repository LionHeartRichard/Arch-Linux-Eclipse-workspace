package tanks.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import tanks.game.display.Display;
import tanks.game.display.logic.MyTime;
import tanks.game.myinput.MyInput;
import tanks.game.textures.TextureAtlasPicteres;

public class Game implements Runnable {

	public static final int WIDTH = 800;
	public static final int HEIGTH = 600;
	public static final String TITLE = "Tanks";
	public static final int CLEAR_COLOR = 0xff000000;
	public static final int NUM_BUFFER = 3;

	public static final float UPDATE_RATE = 60.0f;
	public static final float UPDATE_INTERVAL = MyTime.SECOND / UPDATE_RATE;
	public static final long IDLE_TIME = 1;

	private boolean runing;
	private Thread gameThread;

	private Graphics2D graphics2D;

	float x = 0;
	float y = 0;
	float speed = 3;

	MyInput myInput;

	private TextureAtlasPicteres picterusAtlas;
	public static final String PICTURES_FILE_NAME = "texture_atlas.png";

	public Game() throws IOException {
		runing = false;
		Display.create(WIDTH, HEIGTH, TITLE, CLEAR_COLOR, NUM_BUFFER);
		graphics2D = Display.getGraphics2d();
		myInput = new MyInput();
		Display.addMyInputListener(myInput);
		picterusAtlas = new TextureAtlasPicteres(PICTURES_FILE_NAME);
	}

	public synchronized void start() {
		if (runing)
			return;

		runing = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop() {
		if (!runing)
			return;
		runing = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cleanUp();
		}
	}

	private void update() {
		if (myInput.checkEnterButton(KeyEvent.VK_UP)) {
			y -= speed;
		} else {
			if (myInput.checkEnterButton(KeyEvent.VK_DOWN)) {
				y += speed;
			} else {
				if (myInput.checkEnterButton(KeyEvent.VK_RIGHT)) {
					x += speed;
				} else {
					if (myInput.checkEnterButton(KeyEvent.VK_LEFT)) {
						x -= speed;
					}
				}
			}
		}

	}

	private void render() {

		Display.clear();

		graphics2D.setColor(Color.red);
		graphics2D.drawImage(picterusAtlas.cut(0, 0, 16, 16), 300, 300, null);

		Display.swapBuffer();

	}

	public void run() {

		int fps = 0;
		int upd = 0;
		int updLoop = 0;

		long countTime = 0;

		float delta = 0;

		long lastTime = MyTime.get();
		while (runing) {
			long now = MyTime.get();
			long elapseTime = now - lastTime;
			lastTime = now;

			countTime += elapseTime;

			boolean rendering = false;
			delta += (elapseTime / UPDATE_INTERVAL);
			while (delta > 1) {
				update();
				upd++;
				delta--;
				if (rendering) {
					updLoop++;
				} else {
					rendering = true;
				}
			}
			if (rendering) {
				render();
				fps++;
			} else {
				try {
					Thread.sleep(IDLE_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (countTime >= MyTime.SECOND) {
				Display.setTitle(TITLE + "___Fps:" + fps + " | Upd:" + upd + " | UpLoop:" + updLoop);
				upd = 0;
				updLoop = 0;
				fps = 0;
				countTime = 0;
			}
		}
	}

	private void cleanUp() {
		Display.destroyWindow();
	}

}
