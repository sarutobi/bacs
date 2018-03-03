package base.engine;

/**
 * Класс описывает действия каждой живой бактерии, находящейся на поле.
 *
 */
public final class ActionField {

    private final byte[] field;

    private final int size;

    ActionField(int size) {
        field = new byte[size];
        this.size = size;
    }

    /**
     * Быстрая очистка массива.
     *
     * Алгоритм взят из https://stackoverflow.com/questions/9128737/fastest-way-to-set-all-values-of-an-array
     */
    public void clear() {
        if (size > 0){
            field[0] = 0;
        }

        for (int i = 1; i < size; i += i) {
            System.arraycopy(field, 0, field, i, ((size - i) < i) ? (size - i) : i);
        }
    }

    /**
     *  Занесение информации о действии бактерии
     * @param index координата бактерии
     * @param action код действия.
     */
    public synchronized void setAction(int index, Action action) {
        field[index] = action.getCode();
    }
}
