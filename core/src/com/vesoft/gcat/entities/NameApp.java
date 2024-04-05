package com.vesoft.gcat.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.vesoft.gcat.GCat;


public class NameApp {

    private final GCat appGame;

    private Texture nameAppTexture;

    public NameApp(GCat value) {
        appGame = value;

        nameAppTexture = appGame.getImgFactory().getImageNameApp();
    }

    public void dispose() {
        nameAppTexture.dispose();
    }

    public void draw() {

        appGame.getBatch().begin();
        appGame.getBatch().draw(nameAppTexture, appGame.getImgFactory().getOffsetXNameApp(),
                Gdx.graphics.getHeight() - nameAppTexture.getHeight() - appGame.getImgFactory().getOffsetYNameApp());

        appGame.getBatch().end();
    }
}
