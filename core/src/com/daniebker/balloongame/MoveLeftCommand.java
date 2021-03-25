package com.daniebker.balloongame;

public class MoveLeftCommand implements InputCommand {
    @Override
    public void execute(Player player) {
        player.setMoveLeft();
    }
}
