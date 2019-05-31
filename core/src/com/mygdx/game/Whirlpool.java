package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actor.BaseActor;

public class Whirlpool extends BaseActor {
    public Whirlpool(float x, float y, Stage stage) {
        super(x, y, stage);

        loadAnimationFromSheet("assets/whirlpool.png" , 2 , 5  , 0.1f , false);
    }

    @Override
    public void act(float dt) {
        super.act(dt);

        if (isAnimationFinished())
            this.remove();
    }
}
