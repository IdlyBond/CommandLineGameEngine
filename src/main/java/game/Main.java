package game;

import engine.Engine;
import engine.Game;
import game.MyGame;

public class Main {
    public static void main(String[] args) {

        Game game = new MyGame();
        Engine engine = new Engine(game);
        engine.start();

    }
}
