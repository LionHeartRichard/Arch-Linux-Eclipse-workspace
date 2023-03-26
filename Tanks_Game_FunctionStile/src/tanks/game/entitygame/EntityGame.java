package tanks.game.entitygame;

import java.awt.Graphics2D;

import tanks.game.myinput.MyInput;

public abstract class EntityGame {

	public final EntityType type;

	protected float x;
	protected float y;

	public EntityGame(EntityType type, float x, float y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	protected abstract void update(MyInput myInput);

	protected abstract void render(Graphics2D g);

}
