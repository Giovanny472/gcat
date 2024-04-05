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
    private Animation<TextureRegion> mouseAnimation;
    private static final int FRAME_COLS = 2;
    private static final int FRAME_ROWS = 1;

    private GCat appGame;

    private float speedMouse;
    private float posx, posy;
    private boolean stop;
    private boolean directLeftToRight;

    private final static int deepMouseLeft = 300;
    private final static int deepMouseRight = 600;

    private float mouseStateTime;

    public Mouse(GCat AValue) {

        appGame = AValue;

        mouseTexture = appGame.getImgFactory().getImageMouse();


        TextureRegion[][] listCatRegion = TextureRegion.split(mouseTexture,
                mouseTexture.getWidth() / FRAME_COLS,
                mouseTexture.getHeight() / FRAME_ROWS);

        TextureRegion[] listMouseFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int idx01 = 0; idx01 < FRAME_ROWS; idx01++) {
            for (int idx02 = 0; idx02 < FRAME_COLS; idx02++) {
                listMouseFrames[index++] = listCatRegion[idx01][idx02];
            }
        }


        mouseAnimation = new Animation<>(0.9f, listMouseFrames);
        mouseSpriteBatch = new SpriteBatch();
        mouseSprite = new com.badlogic.gdx.graphics.g2d.Sprite(mouseTexture);;

        speedMouse = appGame.getImgFactory().getSpeedMouse();
        posx = 0f;
        posy = 0f;
        stop = false;
        directLeftToRight = true;
        mouseStateTime = 0;
    }

    public void dispose() {

        mouseTexture.dispose();
        mouseSpriteBatch.dispose();

    }

    public void update() {

        if (posx < (Gdx.graphics.getWidth() + mouseTexture.getHeight()  + deepMouseRight) && directLeftToRight) {
            posy += speedMouse - appGame.getImgFactory().getAngleMouse();
            posx += speedMouse;
        } else if (posy > - (mouseTexture.getHeight() + deepMouseLeft) && !directLeftToRight)  {
            posy -= speedMouse - appGame.getImgFactory().getAngleMouse();
            posx -= speedMouse;
            directLeftToRight = false;
        } else {
            directLeftToRight = !directLeftToRight;
        }
    }

    public void draw() {

        this.update();

        mouseStateTime += Gdx.graphics.getDeltaTime();
        TextureRegion catCurrentFrame = mouseAnimation.getKeyFrame(mouseStateTime, true);
        Sprite aFrame = new Sprite(catCurrentFrame);

        //mouseSpriteBatch.begin();
        //mouseSpriteBatch.draw(catCurrentFrame, posx, posy);
        //mouseSpriteBatch.end();

        mouseSpriteBatch.begin();
        if (directLeftToRight) {
            aFrame.setRotation(0f);
        } else {
            aFrame.setRotation(180f);
        }
        aFrame.setPosition(posx, posy);
        aFrame.draw(mouseSpriteBatch);
        mouseSpriteBatch.end();






//        mouseSpriteBatch.begin();
//        this.update();
//        if (directLeftToRight) {
//            mouseSprite.setRotation(0f);
//        } else {
//            mouseSprite.setRotation(180f);
//        }
//        mouseSprite.setPosition(posx, posy);
//        mouseSprite.draw(mouseSpriteBatch);
//
//        mouseSpriteBatch.end();


    }
}
