package com.vesoft.gcat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

enum TypeSizeScreen {
    SMALL,
    MEDIUM,
    BIG

}

public class ImagesFactory {
    private int sizeScreenW;
    private int sizeScreenH;
    private TypeSizeScreen typeScreen;

    public ImagesFactory() {
        sizeScreenW = Gdx.graphics.getWidth();
        sizeScreenH = Gdx.graphics.getHeight();

        if (sizeScreenH <= 800) {
            typeScreen = TypeSizeScreen.SMALL;
        } else if (sizeScreenH > 800 && sizeScreenH <= 1280) {
            typeScreen = TypeSizeScreen.MEDIUM;
        } else {
            typeScreen = TypeSizeScreen.BIG;
        }
    }

    public Texture getBkgMir01() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("backgroundmir01_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("backgroundmir01_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("backgroundmir01_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("backgroundmir01_big.png"));
                break;
        }
        return tex;
    }

    public Texture getLaser() {
        Texture tex;
        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("laser_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("laser_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("laser_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("laser_big.png"));
                break;
        }
        return tex;
    }


    public int getSpeedLaser() {
        int sp;
        switch (typeScreen){
            case SMALL:
                sp = 4;
                break;
            case MEDIUM:
                sp = 8;
                break;
            case BIG:
                sp = 12;
                break;
            default:
                sp = 1;
                break;
        }
        return sp;
    }

    public Texture getBkgMainMenu() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("backgroundmenu_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("backgroundmenu_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("backgroundmenu_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("backgroundmenu_big.png"));
                break;
        }
        return tex;
    }


    public Texture getBtnPlayUp() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("btnplay_up_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("btnplay_up_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("btnplay_up_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("btnplay_up_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnPlayDown() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("btnplay_down_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("btnplay_down_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("btnplay_down_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("btnplay_down_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnConfigUp() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("btnconfig_up_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("btnconfig_up_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("btnconfig_up_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("btnconfig_up_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnConfigDown() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("btnconfig_down_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("btnconfig_down_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("btnconfig_down_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("btnconfig_down_big.png"));
                break;
        }
        return tex;
    }

}
