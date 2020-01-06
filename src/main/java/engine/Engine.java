package engine;

public class Engine implements MonoBehaviour{
    private Game game;
    public final static int framesPerSec = 60;
    public final static int frame = 1000/framesPerSec;

    public Engine(Game game) {
        this.game = game;
    }

    public void start() {
        game.start();
        try {
            while(true) {
                update();
                draw();
                Thread.sleep(frame);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        game.update();
    }

    public void draw() {
        game.draw();
    }
}
