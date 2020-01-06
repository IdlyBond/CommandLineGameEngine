package engine;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static engine.Characters.NAN;

public abstract class Sprite {
    protected Character[][] sprite;
    protected double width, height;

    public Character[][] getChars(){
        return sprite;
    }

    protected void confirmSize() {
        sprite = new Character[(int)height][(int)width];
    }

    protected void parseSprite(String name) {


        File file = new File("C:\\Users\\idlyb\\IdeaProjects\\CommandLineGameEngine\\src\\main\\resources\\sprites\\" + name);
        if(!file.exists()) throw new RuntimeException("Invalid path to sprite " + name);

        width = 0;
        height = 1;
        try (InputStream in = new FileInputStream(file);
             Reader r = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            Character[][] temp;
            sprite = new Character[(int)height][(int)width];
            int currentWidth = 0;
            int intch;
            while ((intch = r.read()) != -1) {
                char ch = (char) intch;
                if(ch != '\r' && ch != '\n') {
                    if (currentWidth == width) {
                        width++;
                    }
                    currentWidth++;
                    temp = sprite.clone();
                    confirmSize();
                    Utils.copyArray(sprite, temp);
                    for (int i = 0; i < width; i++) {
                        if(Objects.isNull(sprite[(int)height - 1][i])){
                            sprite[(int)height - 1][i] = ch;
                            break;
                        }
                    }
                } else if (ch == '\n'){
                    height++;
                    currentWidth = 0;
                    temp = sprite.clone();
                    confirmSize();
                    Utils.copyArray(sprite, temp);
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (sprite[i][j] == null) sprite[i][j] = NAN.get();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
