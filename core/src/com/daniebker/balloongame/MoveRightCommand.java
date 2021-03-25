package com.daniebker.balloongame;

public class MoveRightCommand implements InputCommand {
    @Override
    public void execute(Player player) {
player.setMoveRight();
    }
}
