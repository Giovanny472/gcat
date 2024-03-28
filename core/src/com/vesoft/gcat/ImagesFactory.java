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
                tex = new Texture(Gdx.files.internal("mir01/backgroundmir01_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("mir01/backgroundmir01_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("mir01/backgroundmir01_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("mir01/backgroundmir01_big.png"));
                break;
        }
        return tex;
    }

    public Texture getLaser() {
        Texture tex;
        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("laser/laser_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("laser/laser_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("laser/laser_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("laser/laser_big.png"));
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
                tex = new Texture(Gdx.files.internal("menu/backgroundmenu_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("menu/backgroundmenu_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("menu/backgroundmenu_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("menu/backgroundmenu_big.png"));
                break;
        }
        return tex;
    }


    public Texture getBtnPlayUp() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_up_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_up_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_up_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_up_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnPlayDown() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_down_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_down_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_down_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("buttons/btnplay_down_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnConfigUp() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_up_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_up_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_up_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_up_big.png"));
                break;
        }
        return tex;
    }

    public Texture getBtnConfigDown() {
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_down_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_down_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_down_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("buttons/btnconfig_down_big.png"));
                break;
        }
        return tex;
    }

    public Texture getImageCat(){
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("cat/cat_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("cat/cat_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("cat/cat_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("cat/cat_small.png"));
                break;
        }
        return tex;
    }


    public int getImageCatPosX() {
        int posx;

        switch (typeScreen){
            case SMALL:
                posx = 200;
                break;
            case MEDIUM:
                posx = 250;
                break;
            case BIG:
                posx = 290;
                break;
            default:
                posx = 100;
                break;
        }
        return posx;

    }

    public int getImageCatPosY() {
        int posy;

        switch (typeScreen){
            case SMALL:
                posy = 190;
                break;
            case MEDIUM:
                posy = 180;
                break;
            case BIG:
                posy = 450;
                break;
            default:
                posy = 100;
                break;
        }
        return posy;

    }

    public Texture getImageMouse(){
        Texture tex;

        switch (typeScreen){
            case SMALL:
                tex = new Texture(Gdx.files.internal("mouse/mouse_small.png"));
                break;
            case MEDIUM:
                tex = new Texture(Gdx.files.internal("mouse/mouse_medium.png"));
                break;
            case BIG:
                tex = new Texture(Gdx.files.internal("mouse/mouse_big.png"));
                break;
            default:
                tex = new Texture(Gdx.files.internal("mouse/mouse_small.png"));
                break;
        }
        return tex;
    }

}

