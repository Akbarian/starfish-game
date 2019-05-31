package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tortoise extends Actor {


    private final TextureRegion textureRegion;
    private Texture texture;
    private Rectangle rectangle;

    public Tortoise(float x , float y) {
        textureRegion = new TextureRegion();
        this.texture = new Texture(Gdx.files.internal("tortoise.png"));
        textureRegion.setRegion(texture);
        rectangle = new Rectangle();
        rectangle.setSize(texture.getWidth() , texture.getHeight());

        setSize(texture.getWidth() , texture.getHeight());
        setPosition(x , y);
    }

    public boolean overlaps(Rectangle other) {
        return rectangle.overlaps(other);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            this.moveBy(-1, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            this.moveBy(1, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            this.moveBy(0, 1);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            this.moveBy(0, -1);

        rectangle.setPosition(getX() , getY());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(textureRegion , getX() , getY());
    }
}
