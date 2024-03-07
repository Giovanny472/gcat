package com.vesoft.gcat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class Mir implements Screen, InputProcessor {

    private GCat appGame;
    private Texture bkgTexture;

    private ArrayList<Laser> listLasers;

    private int speedLaser;


    private static final int countLimitLaser = 10;
    private int limitMakeLaser;


    public Mir(GCat AValue) {

        // game
        appGame = AValue;

        // background
        bkgTexture = appGame.getImgFactory().getBkgMir01();

        // скорость laser
        speedLaser = appGame.getImgFactory().getSpeedLaser();

        // laser
        //laser = new Laser(speedLaser, appGame.getImgFactory().getLaser());
        listLasers = new ArrayList<Laser>();
        makeLaser();

        limitMakeLaser = 0;
    }

    @Override
    public void dispose() {
        bkgTexture.dispose();
    }

    private void makeLaser() {
        listLasers.add(new Laser(speedLaser, appGame.getImgFactory().getLaser()) );
    }

    private Boolean isLaser(Laser lsr) {

        int PosY = Gdx.graphics.getHeight() - lsr.GetY() - lsr.getHeight();

        return (Gdx.input.getX() > lsr.GetX() && Gdx.input.getX() < (lsr.GetX() + lsr.getWidth())
                && Gdx.input.getY() > PosY && Gdx.input.getY() < (PosY + lsr.getHeight()));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        // background
        appGame.getBatch().begin();
        appGame.getBatch().draw(bkgTexture, 0, 0, bkgTexture.getWidth(), bkgTexture.getHeight());
        appGame.getBatch().end();

        appGame.getBatch().begin();

        //for (Laser lsr : listLasers) {
        for (int idx = listLasers.size()-1; idx>=0; idx--){

            Laser lsr = listLasers.get(idx);
            if (lsr.IsDeleted) {
                continue;
            }
            if (Gdx.input.isTouched()) {
                if (isLaser(lsr)) {
                    lsr.IsDeleted = true;
                    if (limitMakeLaser <= countLimitLaser) {
                        makeLaser(); makeLaser();
                        limitMakeLaser++;
                    }
                    continue;
                }
            }

            lsr.Update();
            appGame.getBatch().draw(lsr.GetTexture(), lsr.GetX(), lsr.GetY(), lsr.getWidth(), lsr.getHeight());
        }

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

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
