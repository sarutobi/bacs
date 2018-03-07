package base.engine;

import base.BacUnit;
import base.Command;

/**
 * Игровое поле.
 * Created by valera on 08.03.17.
 */
public class BattleField {

    private final BattleFieldCell[] cells;

    private boolean lumus;

    static final Coords[] lookup = new Coords[]{
            new Coords(0, -1),
            new Coords(1, -1),
            new Coords(1, 0),
            new Coords(1, 1),
            new Coords(0, 1),
            new Coords(-1, 1),
            new Coords(-1, 0),
            new Coords(-1, -1)
    };

    static class Coords {
        int x;
        int y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int dimension;


    private BattleField(int dimension, boolean lumus) {
        this.dimension = dimension;
        this.lumus = lumus;
        cells = new BattleFieldCell[dimension * dimension];
    }

    BattleField(int dimension) {
        this(dimension, false);

    }

    private Coords normalize(int x, int y) {
        return new Coords((x + dimension) % dimension, (y + dimension) % dimension);
    }

    public BattleFieldCell getCell(int x, int y) {
        Coords req = normalize(x, y);
        return cells[req.x + req.y * dimension];
    }

    public int getDimension() {
        return dimension;
    }

}
