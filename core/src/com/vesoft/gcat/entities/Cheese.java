package com.vesoft.gcat.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.vesoft.gcat.GCat;

public class Cheese {

    private final GCat appGame;

    private Texture cheeseTexture;

    public Cheese(GCat value) {
        appGame = value;
        cheeseTexture = appGame.getImgFactory().getImageCheese();
    }

    public void dispose() {
        cheeseTexture.dispose();
    }

    public void draw() {
        appGame.getBatch().begin();
        appGame.getBatch().draw(cheeseTexture, appGame.getImgFactory().getOffsetXCheese(),
                cheeseTexture.getHeight() + appGame.getImgFactory().getOffsetYCheese());

        appGame.getBatch().end();
    }
}
