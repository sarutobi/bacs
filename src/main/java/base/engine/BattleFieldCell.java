package base.engine;

import base.BacUnit;

import java.awt.*;
import java.util.Optional;

public final class BattleFieldCell {

    private final int x;

    private final int y;

    private double light;

    private boolean empty;

    private BacUnit occupant;

    public BattleFieldCell(int x, int y, double light) {
        this.x = x;
        this.y = y;
        this.light = light;
        this.empty = true;
    }

    public void setOccuped(BacUnit occupant) throws IllegalStateException {
        if (! empty)
            throw new IllegalStateException("Ячейка уже занята!");
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

    public Optional<BacUnit> getOccupant() {
        return empty ? Optional.empty() : Optional.of(occupant);
    }
}
