package com.vesoft.gcat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GCat extends Game {

	private SpriteBatch Batch;
	private StartMenu Menu;

	@Override
	public void create() {
		Batch = new SpriteBatch();

		Menu = new StartMenu();
		Menu.Init(this);
		setScreen(Menu);
	}

	public SpriteBatch getBatch() {
		return Batch;
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose () {
		Menu.dispose();
		Batch.dispose();
	}

}
