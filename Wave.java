package lab;
import java.util.List;
import lab.Field.Cell;

public class Wave {

    Field field;
    int[][] labyrinth;
    static Point start;
    static Point end;

    public int[][] Wave(Field field) {
        this.field = field;
        start = field.getStart();
        end = field.getFinish();
        labyrinth = new int[field.getRows()][field.getColumns()];
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.getCell(i, j) == Cell.Barrier) {
                    labyrinth[i][j] = 0;
                } else {
                    labyrinth[i][j] = 1;
                }
            }
        }
        return labyrinth;
    }

    public static void main(String[] args) {
        Field lab = new Field(6, 6);
        lab.putStart(1, 3);
        lab.putFinish(2, 1);
        lab.putBarrier(1, 1);
        lab.putBarrier(1, 2);
        lab.putBarrier(1, 5);
        lab.putBarrier(2, 2);
        lab.putBarrier(3, 4);
        lab.putBarrier(4, 4);
        lab.putBarrier(4, 1);
        lab.putStart(0, 3);
        Wave wave = new Wave();

        WaveAlgorithm wavealg = new WaveAlgorithm(wave.Wave(lab));

        List path = wavealg.find(start, end);
        System.out.println("№ "+" x  " + "y ");
        int i=0;
        for (Object p : path) {
            System.out.print(i+"  ");
            System.out.println(p);
            i++;
        }
    }
}
