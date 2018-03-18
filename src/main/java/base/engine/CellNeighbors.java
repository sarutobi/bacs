package base.engine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Соседние клетки игрового поля
 */
final class CellNeighbors {

    private final Map<Direction, BattleFieldCell> neighbors = new HashMap<>(8);

    void put(Direction direction, BattleFieldCell neighbor) {
        neighbors.put(direction, neighbor);
    }

    Collection<BattleFieldCell> getFields() {
        return neighbors.values();
    }
}
