package com.daniebker.balloongame.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.daniebker.balloongame.BalloonGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {

                return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new BalloonGame();
        }
}