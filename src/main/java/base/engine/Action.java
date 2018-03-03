package base.engine;

/**
 * Действия бактерии, которые записываются в классе ActionField
 */
public enum Action {
    NO_ACTION((byte)0), // Для пустых клеток
    GAIN((byte)1),      // Просто едим
    EAT((byte)2),       // Пытаемся съесть труп
    OBSERVE((byte)3),   // Осматриваемся

    // Перемещения
    MOVE_N((byte)10),   // На клетку вверх
    MOVE_NE((byte)11),  // На клетку вверх-вправо
    MOVE_E((byte)12),   // На клетку вправо
    MOVE_SE((byte)13),  // На клетку вниз-вправо
    MOVE_S((byte)14),   // На клетку вниз
    MOVE_SW((byte)15),  // На клетку вниз-влево
    MOVE_W((byte)16),   // На клетку влево
    MOVE_NW((byte)17);  // На клетку вверх-влево
    private byte code;

    Action(byte code){
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

}
