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

    private Texture bkgTexture;
    float scaleRatioBkgW;
    float scaleRatioBkgH;

    private Stage stg;
    private OrthographicCamera cam;
    private Viewport vip;

    private GCat appGame;

    private  Ball ball;

    public Mir() {

        bkgTexture = new Texture(Gdx.files.internal("backgroundmir01.png"));
        scaleRatioBkgW = (float)Gdx.graphics.getWidth() / bkgTexture.getWidth();
        scaleRatioBkgH = (float)Gdx.graphics.getHeight() / bkgTexture.getHeight();

        ball = new Ball(3);

        //cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //vip = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        //vip.apply();
        //stg = new Stage();
        //Gdx.input.setInputProcessor(stg);

    }

    @Override
    public void dispose() {
        bkgTexture.dispose();
    }

    public void Init(GCat AValue) {
        appGame = AValue;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        appGame.getBatch().begin();
        appGame.getBatch().draw(bkgTexture, 0, 0,
               bkgTexture.getWidth() * scaleRatioBkgW,
               bkgTexture.getHeight() * scaleRatioBkgH);
        appGame.getBatch().end();

        appGame.getBatch().begin();
        ball.Update();
        appGame.getBatch().draw(ball.GetTexture(), ball.GetX(), ball.GetY(),
                ball.getWidth() * ball.getScale(), ball.getHeight() * ball.getScale());
        appGame.getBatch().end();

        //stg.act(delta);
        //stg.draw();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        //vip.update(width, height, true);
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
