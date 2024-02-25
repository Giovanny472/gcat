package com.vesoft.gcat;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;

public class Ball {
    private int PosX;
    private int PosY;

    private int SpeedX;
    private int SpeedY;

    private Boolean IsDeleted;

    private Texture BallTexture;

    public Ball(int speed) {

        this.IsDeleted = false;

        BallTexture = new Texture(Gdx.files.internal("circle.png"));

        this.PosX = MathUtils.random(BallTexture.getWidth(), Gdx.graphics.getWidth() - BallTexture.getWidth());
        this.PosY = MathUtils.random(BallTexture.getHeight(), Gdx.graphics.getHeight() - BallTexture.getHeight());

        if (this.PosX > Gdx.graphics.getWidth() /2) {
            speed *= -1;
        }
        this.SpeedX = speed;

        if (this.PosY > Gdx.graphics.getHeight()/2) {
            speed *= -1;
        }
        this.SpeedY = speed;
    }
    public void Update() {
        PosX += SpeedX;
        PosY += SpeedY;

        if (PosX < 0 || PosX+ BallTexture.getWidth() >= Gdx.graphics.getWidth()) {
            SpeedX = -SpeedX;
        }
        if (PosY < 0 || PosY+ BallTexture.getHeight() >= Gdx.graphics.getHeight()) {
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
        return this.BallTexture;
    }

    public int getWidth(){
        return this.BallTexture.getWidth();
    }

    public int getHeight(){
        return this.BallTexture.getHeight();
    }

    public void SetIsDelete(Boolean Val) {
        IsDeleted = Val;
    }

    public Boolean GetIsDelete() {
        return  IsDeleted;
    }
}
