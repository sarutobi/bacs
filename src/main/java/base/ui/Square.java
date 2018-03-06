package base.ui;

import java.awt.*;

/**
 *  Класс описатель одного прямоугольника для отрисовки.
 */
public final class Square {

    private final int x;

    private final int y;

    private final int size;

    private final Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Square(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
}
