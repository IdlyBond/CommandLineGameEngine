package engine;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public abstract class Game implements MonoBehaviour{
    public String name;
    public Canvas canvas;
    public Listener listener = new Listener();
    //private Map<String, >

    public int frame;

    public void start() {

    }

    public void update() {
        frame++;
        if(frame > Engine.framesPerSec) frame = 1;
        canvas.update();
    }

    public void draw() {
        canvas.draw();
    }
}
