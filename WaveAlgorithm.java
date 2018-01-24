package lab;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class WaveAlgorithm {

    static int x2 = 0;
    static int y2 = 0;
    static int t = 0;
    int[][] map;
    int[][] labyrinth;
    List res = new ArrayList();

    WaveAlgorithm(int[][] labyrinth) {
        this.labyrinth = labyrinth;
        map = new int[labyrinth[0].length][labyrinth.length];
    }

    int[][] Map() {

        return map;
    }

    List find(Point start, Point end) {
        Point p;
        try {
            for (int i = 0; i < map[0].length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("количество строк должно быть другим");
           System.exit(1);
        }
        map[start.getY()][start.getX()] = 0;

        res.add(start);
        int n = 0;
        while (!res.isEmpty()) {
            p = (Point) res.remove(0);
            n++;
            nextPoint(p, n);
        }
        System.out.println("Кратчайший путь обознаен звездочками(*)");
        List path = new ArrayList(); // теперь мы должны из конечной точки придти в начальную
        path.add(end);
        int x = end.getX();
        int y = end.getY();
        n = Integer.MAX_VALUE;

        while ((x != start.getX()) || (y != start.getY())) {// находим меньшего соседа 
            if ((y - 1 >= 0) && map[y - 1][x] < n) {
                prev(y - 1, x);
            }
            if ((y + 1 < map.length) && map[y + 1][x] < n) {
                prev(y + 1, x);
            }
            if ((x - 1 >= 0) && map[y][x - 1] < n) {
                prev(y, x - 1);
            }
            if ((x + 1 < map.length) && map[y][x + 1] < n) {
                prev(y, x + 1);
            }
            x = x2;
            y = y2;
            n = t;
            path.add(new Point(x, y));
        }
        Collections.reverse(path);
        return path;
    }

    private void prev(int i, int j) {//метод для перехода в соседнюю клетку с меньшим значением 
        x2 = j;
        y2 = i;
        t = map[i][j];
    }

    private void nextPoint(Point point, int n) {
        //поиск наименьшего пути до финиша
        //проверяем выходит ли точка за пределы матрицы 
        //и не является ли она барьером.
        //в спомогат. матрице присваиваем значение и добавляем точку в очередь
        Point p;
        if ((point.getY() + 1 < labyrinth.length) && labyrinth[point.getY() + 1][point.getX()] != 0) {
            if (map[point.getY() + 1][point.getX()] > n) {
                p = new Point(point.getX(), point.getY() + 1);
                map[point.getY() + 1][point.getX()] = n;
                res.add(p);
            }
        }
        if ((point.getY() - 1 >= 0) && (labyrinth[point.getY() - 1][point.getX()] != 0)) {
            if (map[point.getY() - 1][point.getX()] > n) {
                p = new Point(point.getX(), point.getY() - 1);
                map[point.getY() - 1][point.getX()] = n;
                res.add(p);
            }
        }
        if ((point.getX() + 1 < labyrinth[point.getY()].length) && (labyrinth[point.getY()][point.getX() + 1] != 0)) {
            if (map[point.getY()][point.getX() + 1] > n) {
                p = new Point(point.getX() + 1, point.getY());
                map[point.getY()][point.getX() + 1] = n;
                res.add(p);
            }
        }
        if ((point.getX() - 1 >= 0) && (labyrinth[point.getY()][point.getX() - 1] != 0)) {
            if (map[point.getY()][point.getX() - 1] > n) {
                p = new Point(point.getX() - 1, point.getY());
                map[point.getY()][point.getX() - 1] = n;
                res.add(p);
            }
        }
    }
}
