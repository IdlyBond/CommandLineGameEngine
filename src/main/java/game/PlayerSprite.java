package game;

import engine.Characters;
import engine.Sprite;

public class PlayerSprite extends Sprite {

    public PlayerSprite() {
        width = 2;
        height = 2;
        confirmSize();
        sprite[0][0] = Characters.POINT.get();
        sprite[0][1] = Characters.POINT.get();
        sprite[1][0] = Characters.POINT.get();
        sprite[1][1] = Characters.POINT.get();
        parseSprite("Test");
    }
}
