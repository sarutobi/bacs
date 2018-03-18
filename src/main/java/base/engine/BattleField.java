package base.engine;

/**
 * Игровое поле.
 * Created by valera on 08.03.17.
 */
public final class BattleField {

    private final BattleFieldCell[] cells;


    static class Coords {
        int x;
        int y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int dimension;

    private final int total;

    BattleField(int dimension) {
        this.dimension = dimension;
        total = dimension * dimension;
        cells = new BattleFieldCell[total];
        for (int i = 0; i < total; i++)
            cells[i] = new BattleFieldCell();

    }

    private Coords normalize(int x, int y) {
        return new Coords((x + dimension) % dimension, (y + dimension) % dimension);
    }

    BattleFieldCell getCell(int x, int y) {
        Coords req = normalize(x, y);
        return cells[req.x + req.y * dimension];
    }

    int getDimension() {
        return dimension;
    }

}
