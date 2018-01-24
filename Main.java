package lab;

import java.util.ArrayList;
import java.util.List;
import static lab.Wave.finish;
import static lab.Wave.start;


public class Main {

    public static void main(String[] args) throws Exception {
        Wave w = new Wave();
        String d = "text2.txt";
        int ss[][] = w.read(d);
        WaveAlgorithm wavealg = new WaveAlgorithm(ss);
        List res = wavealg.find(start, finish);
        w.print(ss, res);
//
//        List<Point> tt1 ;
//        tt1 = new ArrayList<>(7);
//
//        tt1.add(new Point(0, 3));
//        tt1.add(new Point(1, 3));
//        tt1.add(new Point(2, 3));
//        tt1.add(new Point(3, 3));
//        tt1.add(new Point(3, 2));
//        tt1.add(new Point(4, 2));
//        tt1.add(new Point(5, 2));
//        tt1.add(new Point(5, 1));

//        int ss1[][] = w.read(d);
//        WaveAlgorithm wavealg1 = new WaveAlgorithm(ss1);
//        List l = wavealg1.find(start, finish);

//        for (int i = 0; i < tt1.size(); i++) {
//            if (tt1.get(i).equals(l.get(i))) {
//                System.out.println(tt1.get(i));
//            }
//        }

    }
}
