package engine;

import game.PlayerSprite;

import static engine.Characters.*;

public class Canvas implements MonoBehaviour {

    private Integer ySize;
    private Integer xSize;
    private char[][] canvas;

    public Canvas(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        start();
    }

    @Override
    public void start() {
        canvas = new char[ySize][xSize];
    }

    @Override
    public void update() {
        updateSprite(0, 0, new DefaultSprite());
        updateSprite(5, 5, new PlayerSprite());

    }

    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                builder.append(canvas[i][j]);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public void putPoint(int y, int x) {
        if(checkBorders(x, y)) canvas[y][x] = POINT.value;

    }

    public void updateSprite(int x, int y, Sprite sprite){
        for (int i = 0; i < sprite.height; i++) {
            for (int j = 0; j < sprite.width; j++) {
                if (sprite.sprite[i][j] != NAN.value && checkBorders(x + j, y + i)) canvas[y + i][x + j] = sprite.sprite[i][j];
            }
        }
    }

    private boolean checkBorders(int x, int y){
        return x >= 0 && x < this.xSize && y >= 0 && y < this.ySize;
    }

    public Integer getYSize() {
        return ySize;
    }

    public Integer getXSize() {
        return xSize;
    }
}
