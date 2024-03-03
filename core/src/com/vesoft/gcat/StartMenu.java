package com.vesoft.gcat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartMenu implements Screen {

    private Texture btnPlayTexture;
    private TextButton btnPlay;

    private Stage stg;
    private OrthographicCamera cam;
    private Viewport vip;

    private GCat appGame;

    private float ScaleRatioW;
    private float ScaleRatioH;

    private Texture backgroundTexture;

    public void Init(GCat value){
        appGame = value;
    }

    public StartMenu() {

        createComponents();

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

    private void createComponents() {
        backgroundTexture = new Texture(Gdx.files.internal("backgroundmenu.png"));
        btnPlayTexture = new Texture(Gdx.files.internal("buttonplay.png"));

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        vip = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        vip.apply();
    }

    @Override
    public void render(float delta) {

        //Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        //Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
       ScreenUtils.clear(Color.BLACK);

        ScaleRatioW = (float)Gdx.graphics.getWidth() / backgroundTexture.getWidth();
        ScaleRatioH = (float)Gdx.graphics.getHeight() / backgroundTexture.getHeight();
        System.out.println(ScaleRatioW);
        System.out.println(ScaleRatioH);

       appGame.getBatch().begin();
       appGame.getBatch().draw(backgroundTexture, 0, 0,
               backgroundTexture.getWidth() * ScaleRatioW,
               backgroundTexture.getHeight() * ScaleRatioH);
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

    @Override
    public void dispose() {

        btnPlayTexture.dispose();
        stg.dispose();
    }


}
