package com.vesoft.gcat.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vesoft.gcat.GCat;

public class Mouse {

    private Texture mouseTexture;
    private SpriteBatch mouseSpriteBatch;
    private Sprite mouseSprite;

    private GCat appGame;

    private float speedMouse;
    private float posx, posy;
    private boolean stop;
    private boolean directLeftToRight;

    public Mouse(GCat AValue) {

        appGame = AValue;

        mouseTexture = appGame.getImgFactory().getImageMouse();
        mouseSpriteBatch = new SpriteBatch();
        mouseSprite = new com.badlogic.gdx.graphics.g2d.Sprite(mouseTexture);;

        speedMouse = 3f;
        posx = 0f;
        posy = 0f;
        stop = false;
        directLeftToRight = true;
    }

    public void dispose() {

        mouseTexture.dispose();
        mouseSpriteBatch.dispose();

    }

    public void update(){

        if (posx < Gdx.graphics.getWidth()+mouseTexture.getHeight() && directLeftToRight) {
            posy += speedMouse - 1.8f;
            posx += speedMouse;
        } else if (posy > -(mouseTexture.getHeight()+50)&& !directLeftToRight)  {
            posy -= speedMouse - 1.8f;
            posx -= speedMouse;
            directLeftToRight = false;
        } else {
            directLeftToRight = !directLeftToRight;
        }
    }

    public void draw() {

        appGame.getBatch().begin();
        this.update();

        if (directLeftToRight) {
            appGame.getBatch().draw(mouseTexture, posx, posy, mouseTexture.getWidth(), mouseTexture.getHeight());
        } else {
            appGame.getBatch().draw(mouseTexture, posx, posy, mouseTexture.getWidth(), mouseTexture.getHeight());
        }

        appGame.getBatch().end();

    }
}
