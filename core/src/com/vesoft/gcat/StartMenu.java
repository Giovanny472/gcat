package com.vesoft.gcat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartMenu implements Screen {

    private Texture TextureBtn;
    private TextButton btnPlay;
    private TextButton btnExit;

    private Stage stg;
    private OrthographicCamera cam;
    private Viewport vip;


    public StartMenu() {

        stg = new Stage();

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        vip = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        vip.apply();

       //stg.setViewport(vip);

        // status
        TextureBtn = new Texture(Gdx.files.internal("btnStart.png"));
        TextureRegion upBtnTexture = new TextureRegion(TextureBtn, 0,0,300, 150);
        TextureRegion overBtnTexture = new TextureRegion(TextureBtn, 0,150,300, 150);
        TextureRegion downBtnTexture = new TextureRegion(TextureBtn, 0,300,300, 150);

        // style
        TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle();
        btnStyle.font = new BitmapFont();
        btnStyle.fontColor = Color.BLACK;
        btnStyle.up = new TextureRegionDrawable(upBtnTexture);
        btnStyle.over = new TextureRegionDrawable(overBtnTexture);
        btnStyle.down = new TextureRegionDrawable(downBtnTexture);

        // btn
        btnPlay = new TextButton("Play", btnStyle);
        btnExit = new TextButton("Exit", btnStyle);
//        btnPlay.setPosition(200,200);
  //      btnPlay.setVisible(true);

        btnPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen());
            }
        });


        btnExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                //System.exit(-1);

                
            }
        });


        Table tbl = new Table();
        tbl.setFillParent(true);
        tbl.add(btnPlay).pad(5.0f);
        tbl.row();
        tbl.add(btnExit).pad(5.0f);
        tbl.pack();


        stg.addActor(tbl);

        Gdx.input.setInputProcessor(stg);

    }

    @Override
    public void render(float delta) {

        //Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        //Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
       ScreenUtils.clear(Color.BLACK);

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

        TextureBtn.dispose();
        stg.dispose();

        System.exit(0);
    }
}
