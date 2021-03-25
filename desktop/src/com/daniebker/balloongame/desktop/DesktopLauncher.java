package com.daniebker.balloongame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.daniebker.balloongame.BalloonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Untitled Balloon Game";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new BalloonGame(), config);
	}
}
