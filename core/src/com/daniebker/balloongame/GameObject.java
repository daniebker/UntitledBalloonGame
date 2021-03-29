package com.daniebker.balloongame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    protected final Vector2 position;
    protected final Rectangle boundingBox;
    protected final int width;
    protected final int height;
    protected AssetRenderer.TEXTURE_KEY  textureKey;

    public GameObject() {
        position = new Vector2();
        boundingBox = new Rectangle();
        width = 64;
        height = 64;
    }

    public void init() {
        boundingBox
                .setWidth(width)
                .setHeight(height);
    }

    public void update(float delta) {

        boundingBox.setPosition(position);
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

    public AssetRenderer.TEXTURE_KEY getTextureKey() {
        return textureKey;
    }
}
