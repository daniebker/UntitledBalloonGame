package com.daniebker.balloongame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject {

    private final STATE state;
    private final int movementSpeed;

    private MOVEMENT_STATE movementState;

    public Player() {
        super();
        state = STATE.GROUNDED;
        movementState = MOVEMENT_STATE.STILL;
        movementSpeed = 100;
        textureKey = AssetRenderer.TEXTURE_KEY.PLAYER;
    }

    public void init() {
        super.init();
        position.set(128, 64);
        boundingBox
                .setPosition(position);
    }

    public void update(float delta) {
        if (state == STATE.FLOATING) {
            position.x += 35 * delta;
            position.y += 40 * delta;
        }

        switch (movementState) {
            case LEFT:
                moveLeft(delta);
                break;
            case RIGHT:
                moveRight(delta);
                break;
            case STILL:
            default:
                break;
        }

        movementState = MOVEMENT_STATE.STILL;
        super.update(delta);
    }

    public void setMoveLeft() {
        movementState = MOVEMENT_STATE.LEFT;
    }

    public void setMoveRight() {
        movementState = MOVEMENT_STATE.RIGHT;
    }

    private void moveLeft(float delta) {
        if (state == STATE.GROUNDED) {
            position.x -= movementSpeed * delta;
        }

        if (position.x < 0) {
            position.x = 0;
        }
    }

    private void moveRight(float delta) {
        if (state == STATE.GROUNDED) {
            position.x += movementSpeed * delta;
        }
    }

    public enum STATE {
        FLOATING,
        GROUNDED
    }

    public enum MOVEMENT_STATE {
        LEFT,
        RIGHT,
        STILL
    }
}
