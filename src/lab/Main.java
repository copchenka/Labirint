package lab;


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

    }
}
