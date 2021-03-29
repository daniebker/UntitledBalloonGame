package com.daniebker.balloongame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Balloon extends  GameObject {

    public Balloon() {
        super();
        textureKey = AssetRenderer.TEXTURE_KEY.BALLOON;
    }

    @Override
    public void init() {
        super.init();
        position.set(256, 64);
        boundingBox
                .setPosition(position);
    }
}
