package com.vesoft.gcat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartMenu implements Screen {

    private GCat appGame;
    private Mir mirBall;

    private Texture btnPlayTexture;
    private TextButton btnPlay;
    private Texture bkgTexture;

    private Stage stg;
    private OrthographicCamera cam;
    private Viewport vip;

    private float scaleRatioW;
    private float scaleRatioH;

    public StartMenu() {
        createComponents();
        configComponents();
    }

    @Override
    public void dispose() {

        btnPlayTexture.dispose();
        stg.dispose();
        mirBall.dispose();
    }

    private void createComponents() {
        bkgTexture = new Texture(Gdx.files.internal("backgroundmenu.png"));
        scaleRatioW = (float)Gdx.graphics.getWidth() / bkgTexture.getWidth();
        scaleRatioH = (float)Gdx.graphics.getHeight() / bkgTexture.getHeight();

        btnPlayTexture = new Texture(Gdx.files.internal("buttonplay.png"));

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        vip = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        vip.apply();

        mirBall = new Mir();
    }

    public void Init(GCat value){
        appGame = value;
        mirBall.Init(appGame);
    }

    private void configComponents() {

        // texture Button PLAY (press/up)
        TextureRegion upBtnTexture = new TextureRegion(btnPlayTexture, 0,0,400, 235);
        TextureRegion downBtnTexture = new TextureRegion(btnPlayTexture, 0,236,400, 235);

        // style button PLAY
        TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle();
        btnStyle.font = new BitmapFont();
        btnStyle.fontColor = Color.BLACK;
        btnStyle.up = new TextureRegionDrawable(upBtnTexture);
        btnStyle.down = new TextureRegionDrawable(downBtnTexture);

        // кнопки PLAY
        btnPlay = new TextButton("", btnStyle);
        //btnPlay.setPosition(200,200);
        //btnPlay.setVisible(true);

        btnPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen());
                //
                appGame.setScreen(mirBall);
            }
        });

        Table tbl = new Table();
        tbl.setFillParent(true);
        tbl.add(btnPlay).pad(5.0f);
        tbl.pack();

        stg = new Stage();
        stg.addActor(tbl);
        Gdx.input.setInputProcessor(stg);

    }

    @Override
    public void render(float delta) {

        //Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        //Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
       ScreenUtils.clear(Color.BLACK);


       appGame.getBatch().begin();
       appGame.getBatch().draw(bkgTexture, 0, 0,
               bkgTexture.getWidth() * scaleRatioW,
               bkgTexture.getHeight() * scaleRatioH);
       //appGame.getBatch().draw(backgroundTexture, 0, 0);
       appGame.getBatch().end();

       stg.act(delta);
       stg.draw();
    }


    @Override
    public void resize(int width, int height) {
        vip.update(width, height, true);
    }

    @Override
    public void show() {
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
