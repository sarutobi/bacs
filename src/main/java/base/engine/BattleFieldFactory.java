package base.engine;

public class BattleFieldFactory {

    private BattleFieldFactory() {

    }

    public BattleField getEqualsField(int dimension) {
        BattleField target = new BattleField(dimension);
        int halfSize = dimension / 2;
        target.getCell(halfSize, halfSize);
        return target;
    }


}
