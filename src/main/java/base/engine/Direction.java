package base.engine;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0, -1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1);

    static {
        NORTH.toLeft = NORTHWEST;
        NORTH.toRight = NORTHEAST;

        NORTHEAST.toLeft = NORTH;
        NORTHEAST.toRight = EAST;

        EAST.toLeft = NORTHEAST;
        EAST.toRight = SOUTHEAST;

        SOUTHEAST.toLeft = EAST;
        SOUTHEAST.toRight =SOUTH;

        SOUTH.toLeft = SOUTHEAST;
        SOUTH.toRight =SOUTHWEST;

        SOUTHWEST.toLeft =SOUTH;
        SOUTHWEST.toRight = WEST;

        WEST.toLeft =SOUTHWEST;
        WEST.toRight = NORTHWEST;

        NORTHWEST.toLeft = WEST;
        NORTHWEST.toRight = NORTH;
    }

    private final int dx;
    private final int dy;
    private Direction toLeft;
    private Direction toRight;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.toLeft = toLeft;
        this.toRight = toRight;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }

    public Direction toLeft() {
        return toLeft;
    }

    public Direction toRight() {
        return toRight;
    }
}
