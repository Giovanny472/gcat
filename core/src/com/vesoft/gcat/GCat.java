package com.vesoft.gcat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vesoft.gcat.mainmenu.MainMenu;

public class GCat extends Game {

	private SpriteBatch Batch;
	private MainMenu Menu;
	private ImagesFactory imgFactory;

	@Override
	public void create() {
		Batch = new SpriteBatch();

		// для опредения изображений
		imgFactory = new ImagesFactory();

		// cоздание main menu
		Menu = new MainMenu(this);

		// переходим в меню
		setScreen(Menu);
	}

	public SpriteBatch getBatch() {
		return Batch;
	}

	public ImagesFactory getImgFactory(){
		return imgFactory;
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose () {
		imgFactory = null;

		Menu.dispose();
		Batch.dispose();
	}

}
