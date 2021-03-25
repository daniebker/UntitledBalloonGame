package com.daniebker.balloongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AssetRenderer {
    private final Texture playerImage;
    private final Texture groundImage;

    public AssetRenderer() {
        playerImage = new Texture(Gdx.files.internal("player.png"));
        groundImage = new Texture(Gdx.files.internal("ground.png"));
    }

    public void render(SpriteBatch batch, Player player) {
        batch.draw(playerImage, player.getX(), player.getY(), player.getWidth(), player.getHeight());
        for ( int x =0 ; x <= 800 - 32; x += 64) {
            batch.draw(groundImage, x, 0, 64, 64);
        }
    }
}
