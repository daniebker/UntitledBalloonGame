package com.daniebker.balloongame.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler {
    private final InputCommand buttonLeft;
    private final InputCommand buttonRight;

    public InputHandler() {
        buttonLeft = new MoveLeftCommand();
        buttonRight = new MoveRightCommand();
    }

    public InputCommand handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            return buttonLeft;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            return buttonRight;
        }
        return null;
    }
}
