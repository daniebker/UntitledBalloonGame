package com.daniebker.balloongame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private final Vector2 position;
    private final Rectangle boundingBox;
    private final int width;
    private final int height;
    private final STATE state;
    private final int movementSpeed;

    private MOVEMENT_STATE movementState;

    public Player() {
        position = new Vector2();
        boundingBox = new Rectangle();
        width = 64;
        height = 64;
        state = STATE.GROUNDED;
        movementState = MOVEMENT_STATE.STILL;
        movementSpeed = 100;
    }

    public void init() {
        position.set(128, 64);
        boundingBox
                .setPosition(position)
                .setWidth(width)
                .setHeight(height);
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

        boundingBox.setPosition(position);
        movementState = MOVEMENT_STATE.STILL;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
