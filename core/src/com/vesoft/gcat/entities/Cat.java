package com.vesoft.gcat.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vesoft.gcat.GCat;

public class Cat {

    private Texture catTexture;
    private SpriteBatch catSpriteBatch;
    private Animation<TextureRegion> catAnimation;
    private static final int FRAME_COLS = 4;
    private static final int FRAME_ROWS = 1;
    private float catStateTime;


    private GCat appGame;

    public Cat(GCat AValue) {

        appGame = AValue;

        catTexture = appGame.getImgFactory().getImageCat();


        TextureRegion[][] listCatRegion = TextureRegion.split(catTexture,
                catTexture.getWidth() / FRAME_COLS,
                catTexture.getHeight() / FRAME_ROWS);


        TextureRegion[] listCatFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int idx01 = 0; idx01 < FRAME_ROWS; idx01++) {
            for (int idx02 = 0; idx02 < FRAME_COLS; idx02++) {
                listCatFrames[index++] = listCatRegion[idx01][idx02];
            }
        }

        catAnimation = new Animation<>(0.9f, listCatFrames);
        catSpriteBatch = new SpriteBatch();
        catStateTime = 0;
    }

    public void dispose() {
        catTexture.dispose();
        catSpriteBatch.dispose();
    }

    public void draw() {
        catStateTime += Gdx.graphics.getDeltaTime();
        TextureRegion catCurrentFrame = catAnimation.getKeyFrame(catStateTime, true);
        catSpriteBatch.begin();
        catSpriteBatch.draw(catCurrentFrame, appGame.getImgFactory().getImageCatPosX(), appGame.getImgFactory().getImageCatPosY());
        catSpriteBatch.end();
    }
}
