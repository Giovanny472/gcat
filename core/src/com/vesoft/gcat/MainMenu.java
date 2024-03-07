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

public class MainMenu implements Screen {

    private GCat appGame;
    private Mir mirLaser;
    private Stage stg;

    private Texture bkgTexture;


    private TextButton btnPlay;
    private Texture btnPlayTextureUp, btnPlayTextureDown;


    private TextButton btnConfig;
    private Texture btnConfigTextureUp, btnConfigTextureDown;


    public MainMenu(GCat value) {

        appGame = value;
        mirLaser = new Mir(appGame);

        createButtons();
    }

    @Override
    public void dispose() {

        bkgTexture.dispose();
        mirLaser.dispose();
        stg.dispose();

    }

    private void createButtons() {

        // texture brackground
        bkgTexture = appGame.getImgFactory().getBkgMainMenu();

        // button - PLAY
        btnPlayTextureUp = appGame.getImgFactory().getBtnPlayUp();
        btnPlayTextureDown = appGame.getImgFactory().getBtnPlayDown();
        // region - button PLAY (press/up)
        TextureRegion btnPlayUpRegion = new TextureRegion(btnPlayTextureUp, 0,0, btnPlayTextureUp.getWidth(), btnPlayTextureUp.getHeight());
        TextureRegion btnPlayDownRegion = new TextureRegion(btnPlayTextureDown, 0,0, btnPlayTextureDown.getWidth(), btnPlayTextureDown.getHeight());
        // style - button PLAY
        TextButton.TextButtonStyle btnPlayStyle = new TextButton.TextButtonStyle();
        btnPlayStyle.font = new BitmapFont();
        btnPlayStyle.up = new TextureRegionDrawable(btnPlayUpRegion);
        btnPlayStyle.down = new TextureRegionDrawable(btnPlayDownRegion);
        // Btn PLAY
        btnPlay = new TextButton("", btnPlayStyle);
        btnPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                appGame.setScreen(mirLaser);
            }
        });


        // button - CONFIG
        btnConfigTextureUp = appGame.getImgFactory().getBtnConfigUp();
        btnConfigTextureDown = appGame.getImgFactory().getBtnConfigDown();
        // region - button CONFIG (press/up)
        TextureRegion btnConfigUpRegion = new TextureRegion(btnConfigTextureUp, 0,0, btnConfigTextureUp.getWidth(), btnConfigTextureUp.getHeight());
        TextureRegion btnConfigDownRegion = new TextureRegion(btnConfigTextureDown, 0,0, btnConfigTextureDown.getWidth(), btnConfigTextureDown.getHeight());
        // style - button CONFIG
        TextButton.TextButtonStyle btnConfigStyle = new TextButton.TextButtonStyle();
        btnConfigStyle.font = new BitmapFont();
        btnConfigStyle.up = new TextureRegionDrawable(btnConfigUpRegion);
        btnConfigStyle.down = new TextureRegionDrawable(btnConfigDownRegion);
        // Btn CONFIG
        btnConfig = new TextButton("", btnConfigStyle);
        btnConfig.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //appGame.setScreen(mirLaser);
            }
        });



        Table tbl = new Table();
        tbl.setFillParent(true);

        tbl.add(btnPlay).left();
        tbl.add(btnConfig).right();
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
       appGame.getBatch().draw(bkgTexture, 0, 0);
       appGame.getBatch().end();

        stg.act(delta);
        stg.draw();

    }


    @Override
    public void resize(int width, int height) {

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
