package com.daniebker.balloongame.input;

import com.daniebker.balloongame.Player;

public class MoveRightCommand implements InputCommand {
    @Override
    public void execute(Player player) {
player.setMoveRight();
    }
}
