package com.vesoft.gcat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Mir implements Screen {


    private GCat appGame;
    private Texture bkgTexture;
    private  Laser laser;

    private int speedLaser;

    public Mir(GCat AValue) {

        // game
        appGame = AValue;

        // background
        bkgTexture = appGame.getImgFactory().getBkgMir01();

        // скорость laser
        speedLaser = appGame.getImgFactory().getSpeedLaser();

        // laser
        laser = new Laser(speedLaser, appGame.getImgFactory().getLaser());

    }

    @Override
    public void dispose() {
        bkgTexture.dispose();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        // background
        appGame.getBatch().begin();
        appGame.getBatch().draw(bkgTexture, 0, 0, bkgTexture.getWidth(), bkgTexture.getHeight());
        appGame.getBatch().end();

        appGame.getBatch().begin();
        laser.Update();
        appGame.getBatch().draw(laser.GetTexture(), laser.GetX(), laser.GetY(), laser.getWidth(), laser.getHeight() );
        appGame.getBatch().end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

}
