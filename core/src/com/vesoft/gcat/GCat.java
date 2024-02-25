package com.vesoft.gcat;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class GCat extends Game { //implements InputProcessor { //ApplicationAdapter implements InputProcessor {

	private int  BallsCount = 10;
	private ArrayList<Ball> ListBalls = new ArrayList<Ball>();
	private SpriteBatch batch;
	private Score ScoreBall;
	BitmapFont FontName;


	Skin FSkin;


	@Override
	public void create() {

		setScreen(new StartMenu());

/*
		// создание balls
		for (int idx =0; idx<BallsCount; idx++) {
			MakeBall();
		}

		batch = new SpriteBatch();
		ScoreBall = new Score();
		FontName = new BitmapFont();




		//FSkin = new Skin();
		//FSkin.add("btnStart", );

*/
	}

	public void MakeBall() {
		//ListBalls.add(new Ball(1));
	}

	@Override
	public void render() {
		super.render();
/*
		Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);

		batch.begin();

		for (Ball LBall : ListBalls) {

			if (LBall.GetIsDelete()) {
				continue;
			}

			if (Gdx.input.isTouched()) {

				if (IsBall(LBall)) {
					LBall.SetIsDelete(true);
					ScoreBall.Increment();
					continue;
				}
			}

			LBall.Update();
			batch.draw(LBall.GetTexture(), LBall.GetX(), LBall.GetY());

			FontName.setColor(0.5f, 0.3f, 0.3f, 1.0f);
			FontName.draw(batch, ScoreBall.GetScoreStr(), 50, 50);

		}




		batch.end();


 */
	}

	private Boolean IsBall(Ball ABall) {

		int PosY = Gdx.graphics.getHeight() - ABall.GetY() - ABall.getHeight();

		return (Gdx.input.getX() > ABall.GetX() && Gdx.input.getX() < (ABall.GetX() + ABall.getWidth())
				&& Gdx.input.getY() > PosY && Gdx.input.getY() < (PosY + ABall.getHeight()));
	}

	@Override
	public void dispose () {
		ListBalls.clear();
		batch.dispose();
		FontName.dispose();
	}

	/*
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
	*/
}
