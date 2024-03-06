package com.vesoft.gcat;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;

public class Laser {
    private int PosX;
    private int PosY;

    private int SpeedX;
    private int SpeedY;

    private Boolean IsDeleted;

    private Texture ballTexture;

    private float scaleRatio;

    private int sizeBall;

    public Laser(int speed, Texture laser) {

        this.IsDeleted = false;

        ballTexture = laser;
        sizeBall = (int)(ballTexture.getHeight());

        this.PosX = MathUtils.random(sizeBall, Gdx.graphics.getWidth() - sizeBall);
        this.PosY = MathUtils.random(sizeBall, Gdx.graphics.getHeight() - sizeBall);

        if (this.PosX > Gdx.graphics.getWidth()/2) {
            speed *= -1;
        }
        this.SpeedX = speed;

        if (this.PosY > Gdx.graphics.getHeight()/2) {
            speed *= -1;
        }
        this.SpeedY = speed;
    }

    public float getScale() {
        return  scaleRatio;
    }

    public void Update() {
        PosX += SpeedX;
        PosY += SpeedY;

        if (PosX < 0 || PosX+ sizeBall>= Gdx.graphics.getWidth()) {
            SpeedX = -SpeedX;
        }
        if (PosY < 0 || PosY+ sizeBall >= Gdx.graphics.getHeight()) {
            SpeedY = -SpeedY;
        }
    }

    public int GetX() {
        return  this.PosX;
    }

    public int GetY() {
        return  this.PosY;
    }

    public Texture GetTexture() {
        return ballTexture;
    }

    public int getWidth(){
        return ballTexture.getWidth();
    }

    public int getHeight(){
        return ballTexture.getHeight();
    }

    public void SetIsDelete(Boolean Val) {
        IsDeleted = Val;
    }

    public Boolean GetIsDelete() {
        return  IsDeleted;
    }
}
