package lab;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static lab.Wave.finish;
import static lab.Wave.start;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void testSomeMethod() {//просто проверка поиска пути
        List<Point> tt2 = new ArrayList<>();

        tt2.add(new Point(0, 3));
        tt2.add(new Point(1, 3));
        tt2.add(new Point(2, 3));
        tt2.add(new Point(3, 3));
        tt2.add(new Point(3, 2));
        tt2.add(new Point(4, 2));
        tt2.add(new Point(5, 2));
        tt2.add(new Point(5, 1));

        Wave w = new Wave();
        String t2 = "text2.txt";
        int ss2[][] = w.read(t2);
        WaveAlgorithm wavealg2 = new WaveAlgorithm(ss2);
        assertEquals(tt2, wavealg2.find(start, finish));
    }

    @Test
    public void testSomeMethod1() {// + на другой карте
        List<Point> tt1 = new ArrayList<>();

        tt1.add(new Point(0, 3));
        tt1.add(new Point(1, 3));
        tt1.add(new Point(2, 3));
        tt1.add(new Point(3, 3));
        tt1.add(new Point(3, 2));
        tt1.add(new Point(3, 1));
        tt1.add(new Point(2, 1));

        Wave w1 = new Wave();
        String t1 = "text1.txt";
        int ss1[][] = w1.read(t1);
        WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
        assertEquals(tt1, wavealg1.find(start, finish));

    }

    @Test
    public void testSomeMethod2() throws Exception {//наполнение лабиринта
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

        Wave w2 = new Wave();
        String t = "text.txt";
        try {
            int ss1[][] = w2.read(t);
            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (Exception ex) {
            System.err.println("Лабиринт может состоять только из: 0 1 S F ");

        }
    }

    @Test
    public void testSomeMethod3() throws IOException {// отсутсиве ФАЙЛА
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

      
        Wave w2 = new Wave();
        String t = "text8888.txt";
        try {
            int ss1[][] = w2.read(t);

            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (Exception ex) {
            System.err.println("File not found ");
           
        }
    }
    @Test
    public void testSomeMethod4() throws Exception {// старт и финиш должны быть одни
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

        Wave w2 = new Wave();
        String t = "text3.txt";
        try {
            int ss1[][] = w2.read(t);
            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (IllegalArgumentException ex) {
            System.err.println("старт и финиш должны быть одни ");

        }
    }

    @Test
    public void testSomeMethod5() throws Exception {// проверка формата строк и столбцов
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

        Wave w2 = new Wave();
        String t = "text5.txt";
        try {
            int ss1[][] = w2.read(t);
            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (NullPointerException ex) {
            System.err.println("Формат кол-ва строк и столбцов совсем не тот");
        }
    }

    @Test
    public void testSomeMethod6() throws Exception {// спроверка на не отрицательность строк и столбцов
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

        Wave w2 = new Wave();
        String t = "text6.txt";
        try {
            int ss1[][] = w2.read(t);
            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (NullPointerException ex) {
            System.err.println("Эти переменные не могут быть отрицательными ");

        }
    }

    @Test
    public void testSomeMethod7() throws Exception {// наличие старта и финиша
        List<Point> tt = new ArrayList<>();

        tt.add(new Point(0, 3));
        tt.add(new Point(0, 2));
        tt.add(new Point(0, 1));
        tt.add(new Point(0, 0));
        tt.add(new Point(1, 0));
        tt.add(new Point(2, 0));
        tt.add(new Point(2, 1));

        Wave w2 = new Wave();
        String t = "text7.txt";
        try {
            int ss1[][] = w2.read(t);
            WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
            assertEquals(tt, wavealg1.find(start, finish));
        } catch (IllegalArgumentException ex) {
            System.err.println("отсутсвие старта или финиша");

        }
    }

}
