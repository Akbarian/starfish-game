package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Spaceship extends BaseActor {

    public int shieldPower;
    private Thrusters thrusters;
    private Shield shield;

    public Spaceship(float x, float y, Stage stage) {
        super(x, y, stage);

        loadTexture("assets/spaceship.png");
        setBoundaryPolygon(8);
        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);

        thrusters = new Thrusters(0, 0, stage);
        addActor(thrusters);
        thrusters.setPosition(-thrusters.getWidth(), getHeight() / 2 - thrusters.getHeight() / 2);

        shield = new Shield(0, 0, stage);
        addActor(shield);
        shield.centerAtPosition(getWidth() / 2, getHeight() / 2);
        shieldPower = 100;
    }

    public void act(float dt) {
        super.act(dt);
        float degreesPerSecond = 120; // rotation speed
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            rotateBy(degreesPerSecond * dt);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            rotateBy(-degreesPerSecond * dt);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            thrusters.setVisible(true);
            accelerateAtAngle(getRotation());
        } else {
            thrusters.setVisible(false);
        }

        applyPhysics(dt);

        wrapAroundWorld();

        shield.setOpacity(shieldPower / 100f);
        if (shieldPower <= 0) {
            shield.setVisible(false);
        }


    }

    public void warp() {
        if (getStage() == null) return;
        Warp warp1 = new Warp(0, 0, this.getStage());
        warp1.centerAtActor(this);
        setPosition(MathUtils.random(800), MathUtils.random(600));
        Warp warp2 = new Warp(0, 0, this.getStage());
        warp2.centerAtActor(this);
    }

    public void shoot() {
        if (getStage() == null) return;
        Laser laser = new Laser(0, 0, this.getStage());
        laser.centerAtActor(this);
        laser.setRotation(this.getRotation());
        laser.setMotionAngle(this.getRotation());
    }
}
