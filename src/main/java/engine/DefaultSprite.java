package engine;

import game.MyGame;

public class DefaultSprite extends Sprite {
    public DefaultSprite() {
        width = MyGame.game.canvas.getXSize();
        height = MyGame.game.canvas.getYSize();
        confirmSize();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sprite[i][j] = Characters.EMPTY.value;
            }
        }
    }
}
