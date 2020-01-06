package engine;

import game.MyGame;

import static java.lang.Math.round;

public class Actor implements MonoBehaviour{

    private double x;
    private double y;

    private double moveSpeed;
    private double xSpeed;
    private double ySpeed;
    private double gravity;

    private int jumpCounter;
    private boolean jumped;

    public Actor() {
        start();
    }

    @Override
    public void start() {
        x = 20;
        y = 20;
        moveSpeed = 0.57;
        xSpeed = 0;
        ySpeed = 0;
        gravity = 0.3;
    }

    @Override
    public void update() {
        setMoving();
        x += xSpeed;
        if(y + ySpeed + gravity <= 20) {
            y += ySpeed;
            y += gravity;
        }
        MyGame.game.canvas.putPoint((int)round(y), (int)round(x));

    }

    @Override
    public void draw() {

    }

    private void setMoving() {
        if (MyGame.game.listener.keyRight || MyGame.game.listener.keyLeft) {
            if (MyGame.game.listener.keyRight) xSpeed = moveSpeed;
            if (MyGame.game.listener.keyLeft) xSpeed = -moveSpeed;
        } else xSpeed = 0;
        if(MyGame.game.listener.keyUp && jumpCounter < 20 && !jumped) {
            ySpeed = -moveSpeed;
            jumpCounter++;
        } else {
            if(jumpCounter > 0) {
                jumped = true;
                jumpCounter--;
            }
            if(y + 1 > 20) jumped = false;
            ySpeed = 0;
        }
    }
}
