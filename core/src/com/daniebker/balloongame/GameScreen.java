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

    public GameScreen(BalloonGame balloonGame) {
        game = balloonGame;
        player = new Player();
        camera = new OrthographicCamera();
        assetRenderer = new AssetRenderer();
        inputHandler = new InputHandler();
    }

    @Override
    public void show() {
        player.init();
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
        game.batch.end();
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
