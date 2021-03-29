package com.daniebker.balloongame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.daniebker.balloongame.input.InputCommand;
import com.daniebker.balloongame.input.InputHandler;

public class GameScreen implements Screen {
    private final BalloonGame game;
    private final Player player;
    private final OrthographicCamera camera;
    private final AssetRenderer assetRenderer;
    private final InputHandler inputHandler;
    private final Balloon balloon;

    public GameScreen(BalloonGame balloonGame) {
        game = balloonGame;
        player = new Player();
        balloon = new Balloon();
        camera = new OrthographicCamera();
        assetRenderer = new AssetRenderer();
        inputHandler = new InputHandler();
    }

    @Override
    public void show() {
        player.init();
        balloon.init();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        InputCommand inputCommand = inputHandler.handleInput();
        if (inputCommand != null) {
            inputCommand.execute(player);
        }

        camera.update();
        player.update(delta);

        game.batch.begin();
        assetRenderer.render(game.batch, player);
        assetRenderer.render(game.batch, balloon);
        drawGround();
        game.batch.end();
    }

    private void drawGround() {
        for ( int x =0 ; x <= 800 - 32; x += 64) {
            final int finalX = x;
            assetRenderer.render(game.batch, new GameObject() {
                @Override
                public float getX() {
                    return finalX;
                }

                @Override
                public AssetRenderer.TEXTURE_KEY getTextureKey() {
                    return AssetRenderer.TEXTURE_KEY.GROUND;
                }
            });
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
