package com.daniebker.balloongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Hashtable;
import java.util.Map;

public class AssetRenderer {
    private final Map<TEXTURE_KEY, Texture> textures;

    public AssetRenderer() {
        textures = new Hashtable<>();
        textures.put(TEXTURE_KEY.PLAYER, new Texture(Gdx.files.internal("player.png")));
        textures.put(TEXTURE_KEY.GROUND, new Texture(Gdx.files.internal("ground.png")));
        textures.put(TEXTURE_KEY.BALLOON, new Texture(Gdx.files.internal("balloon.png")));
    }

    public void render(SpriteBatch batch, GameObject gameObject) {
        Texture image = textures.get(gameObject.getTextureKey());
        batch.draw(image, gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight());
    }

    public enum TEXTURE_KEY {
        PLAYER,
        GROUND,
        BALLOON
    }
}
