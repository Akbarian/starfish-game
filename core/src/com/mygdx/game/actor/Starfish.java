package com.mygdx.game.actor;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Starfish extends BaseActor {
    public boolean collected;

    public Starfish(float x, float y, Stage stage) {
        super(x, y, stage);

        loadTexture("assets/starfish.png");

        Action spin = Actions.rotateBy(30, 1);
        this.addAction(Actions.forever(spin));

        collected = false;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
        clearActions();
        addAction(Actions.fadeOut(1));
        addAction(Actions.after(Actions.removeActor()));
    }

}
