package lab;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class WaveAlgorithm {

    int[][] map;
    int[][] labyrinth;
    List res = new ArrayList();

    WaveAlgorithm(int[][] labyrinth) {
        this.labyrinth = labyrinth;
        map = new int[labyrinth[0].length][labyrinth.length];
    }

    List find(Point start, Point end) {
        int x2 = 0, y2 = 0, n = 0, t = 0;
        Point p;
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[start.getY()][start.getX()] = 0;
        res.add(start);

        while (!res.isEmpty()) {
            p = (Point) res.remove(0);
            n++;
            nextPoint(p, n);
        }
        System.out.println("Координаты найденого пути");
        List path = new ArrayList(); // теперь мы должны из конечной точки придти в начальную
        path.add(end);
        int x = end.getX();
        int y = end.getY();
        n = Integer.MAX_VALUE;
        while ((x != start.getX()) || (y != start.getY())) {// находим меньшего соседа 
            if (map[y - 1][x] < n) {
                x2 = x;
                y2 = y - 1;
                t = map[y - 1][x];
            }
            if (map[y + 1][x] < n) {
                x2 = x;
                y2 = y + 1;
                t = map[y + 1][x];
            }
            if (map[y][x - 1] < n) {
                x2 = x - 1;
                y2 = y;
                t = map[y][x - 1];
            }
            if (map[y][x + 1] < n) {
                x2 = x + 1;
                y2 = y;
                t = map[y][x + 1];
            }

            x = x2;
            y = y2;
            n = t;
            path.add(new Point(x, y));
        }

        Collections.reverse(path);
        return path;
    }

    private void nextPoint(Point point, int n) {
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
