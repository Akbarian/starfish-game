package com.mygdx.game;

public class StarfishGame extends BaseGame {
    @Override
    public void create() {
        setActiveScreen(new MenuScreen());
    }
}
