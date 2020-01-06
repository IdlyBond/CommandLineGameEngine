package game;

import engine.Actor;
import engine.Canvas;
import engine.Game;

public class MyGame extends Game {

    public static MyGame game;
    public Actor actor;

    public MyGame() {
        start();
    }

    @Override
    public void start() {
        super.start();
        game = this;
        name = "MyGame";
        this.canvas = new Canvas(100, 30);
        actor  = new Actor();
    }

    @Override
    public void update() {
        super.update();
        actor.update();


    }

    @Override
    public void draw() {
        super.draw();
    }
}
