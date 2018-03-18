package base.engine;

import base.BacUnit;

import java.awt.*;
import java.util.*;
import java.util.List;

public final class BattleFieldCell {

    private double light;

    private boolean empty;

    // Кандидаты на размещение в клетке на следующем ходу.
    private final List<BacUnit> candidates = new ArrayList<>(9);

    // Соседи текущей клетки игрового поля
    private final CellNeighbors neighbors = new CellNeighbors();

    private BacUnit occupant;

    BattleFieldCell() {
        this.empty = true;
    }

    public void setOccuped(BacUnit occupant) throws IllegalStateException {
        this.occupant = occupant;
        this.empty = false;
    }

    public BacUnit free() {
        this.empty = true;
        BacUnit unit = occupant;
        occupant = null;
        return unit;
    }

    public Color getColor() {
        return empty ? Color.black : Color.decode("#" + occupant.clr);
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    Optional<BacUnit> getOccupant() {
        return empty ? Optional.empty() : Optional.of(occupant);
    }
}
