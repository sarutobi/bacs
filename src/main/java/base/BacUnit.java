package base;

public class BacUnit {
    public static int actlim = 20;  //maximum number of actions
    public static int comnum = 6;   //number of commands available
    public static int relsense = 5; //how much relative can differ
    public static int gainbase = 5; //energy gained with gain ability

    public boolean changed;
    // Параметры клетки
    public int str;
    public int end;
    public int mut;
    public String clr;

    public float energy;
    public int direction;  // Направление перемещения или атаки
    public int action = 0; // Номер отрабатываемой команды

    public int ticks; //Время жизни клетки в ходах
    public int[] behaviour = new int[23]; // последовательность действий клетки

    public static BacUnit getInitial(int strength, int mutagen, int end) {
        BacUnit initial = new BacUnit();
        initial.clr = "#FF0000";
        initial.direction = 0;
        initial.str = strength;
        initial.mut = mutagen;
        initial.end = end;
        initial.energy = 50;
        initial.behaviour[0] = Command.GAIN.getCode();
        initial.changed = true;
        return initial;
    }

    private BacUnit() {
        this.clr = "000000";
    }

    public int getMyAction() {
        action %= actlim;
        int actionCode = behaviour[action];
        action++;
        return actionCode;
    }

    public void gain(double light) {
        energy += gainbase * light;
    }

    public void turn(int dir) {
        if (dir % 2 == 0) {
            direction = (direction + 1) % 8;
        } else {
            direction = (direction + 7) % 8;
        }
    }

    public String getColorCode() {
        return clr;
    }

}