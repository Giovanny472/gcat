package com.vesoft.gcat.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vesoft.gcat.GCat;

public class MouseStop {

        private Texture mouseTexture;
        private SpriteBatch mouseSpriteBatch;
        private Sprite mouseSprite;
        private Animation<TextureRegion> mouseAnimation;
        private static final int FRAME_COLS = 2;
        private static final int FRAME_ROWS = 1;

        private GCat appGame;

        private float posx, posy;


        private float mouseStateTime;
        private float frameDuration;

        public MouseStop(GCat AValue) {

            appGame = AValue;
            mouseTexture = appGame.getImgFactory().getImageMouseStop();

            posx = appGame.getImgFactory().getImageMouseStopPosX();
            posy = appGame.getImgFactory().getImageMouseStopPosY();
            frameDuration = 2.5f;
            mouseStateTime = 0;

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


            mouseAnimation = new Animation<>(frameDuration, listMouseFrames);
            mouseSpriteBatch = new SpriteBatch();
            mouseSprite = new com.badlogic.gdx.graphics.g2d.Sprite(mouseTexture);

        }

        public void dispose() {

            mouseTexture.dispose();
            mouseSpriteBatch.dispose();

        }

        public void draw() {

            mouseStateTime += Gdx.graphics.getDeltaTime();
            TextureRegion catCurrentFrame = mouseAnimation.getKeyFrame(mouseStateTime, true);
            Sprite aFrame = new Sprite(catCurrentFrame);

            mouseSpriteBatch.begin();
            //aFrame.setRotation(20f);

            aFrame.setPosition(posx, posy);
            aFrame.draw(mouseSpriteBatch);
            mouseSpriteBatch.end();

        }
    }

