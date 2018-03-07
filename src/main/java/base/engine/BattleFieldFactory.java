package base.engine;

public final class BattleFieldFactory {

    public BattleField getEqualField(int dimension) {
        BattleField field = new BattleField(dimension);

        for (int x = 0; x < dimension; x++)
            for (int y = 0; y < dimension; y++){

            }
//                field.getCell(x, y).light = 1;

        return field;
    }

    public BattleField getLumusField(int dimension) {
        BattleField field = new BattleField(dimension);

        int center = dimension / 2;
        double maxDistance = Math.sqrt(2) * center;

        for (int x = 0; x < dimension; x++)
            for (int y = 0; y < dimension; y++) {
                int dx = center - x;
                int dy = center - y;
                double delta = Math.sqrt(dx * dx + dy * dy);
//                field.getCell(x, y).light = (maxDistance - delta) / maxDistance;
            }
        return field;
    }
}
