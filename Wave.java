package lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wave {

    private int[][] ss;
    static Point start;
    static Point finish;
    private List res = new ArrayList();
    private int Height;
    private int Width;
    static BufferedReader buf;
    String[] splt;
    private int[][] result;
    boolean f = false;
    boolean st = false;
    int ddd;

    public int[][] read(String s) {
        String str;

        try {
            buf = new BufferedReader(new FileReader(s));

            try {
                splt = buf.readLine().split("\\s+");

                Height = Integer.parseInt(splt[0]);
                Width = Integer.parseInt(splt[1]);
                if (Height <= 0 || Width <= 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                result = new int[Height][Width];
                int cnt = 0;
                while (cnt < Height) {
                    str = buf.readLine();
                    if (str == null) {
                        cnt--;
                        break;
                    }

                    if (str.length() > Width) {
                        splt = str.split("\\s+");
                        if (splt.length != Width) {
                            try {
                                throw new Exception();
                            } catch (Exception ex) {
                                System.err.println("Количество столбцов должно быть другим по значению");
                                System.exit(1);
                            }
                        }
                        for (int i = 0; i < Width; i++) {
                            if (splt[i].equals("F")) {
                                if (f == true) {
                                    throw new IllegalArgumentException("Финиш должен быть только один");
                                }
                                result[cnt][i] = 1;
                                finish = new Point(i, cnt);
                                f = true;
                            } else if (splt[i].equals("S")) {
                                if (st == true) {
                                    throw new IllegalArgumentException("Старт должен быть только один");
                                }
                                result[cnt][i] = 1;
                                start = new Point(i, cnt);
                                st = true;
                            } else if (splt[i].equals("0") || splt[i].equals("1")) {
                                result[cnt][i] = Integer.parseInt(splt[i]);
                            } else {
                                try {
                                    throw new Exception();
                                } catch (Exception ex) {
                                    System.err.println("Лабиринт может состоять только из: 0 1 S F ");
                                   // System.exit(1);
                                }
                            }
                        }
                       
                            cnt++;
                        
                    }
                } if (!f||!st) {throw new IllegalArgumentException("Поставьте старт или финиш");}
            } catch (IOException ex) {
                Logger.getLogger(Wave.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Строки и столбцы должны быть больше нуля");
            ex.getMessage();
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(1);
        } catch (NegativeArraySizeException e) {
            System.err.println("Отрицательное значение");
            System.exit(1);
        } catch (NumberFormatException ex) {
            System.err.println("Формат кол-ва строк и столбцов совсем не тот");
            System.exit(1);
        }

        return result;
    }

    public void print(int ss[][], List res) {
        BufferedWriter br;
        try {
            Point p;
            br = new BufferedWriter(new FileWriter("out.txt"));
            for (int i = 0; i < ss.length; i++) {
                for (int j = 0; j < ss[0].length; j++) {
                    boolean g = false;
                    for (int c = 1; c < res.size() - 1; c++) {
                        p = (Point) res.get(c);
                        if (j == p.getX() && i == p.getY()) {
                            br.write("* ");
                            g = true;
                        }
                    }
                    if (!g) {
                        if (new Point(j, i).equals(start)) {
                            br.write("S ");
                        } else if (new Point(j, i).equals(finish)) {
                            br.write("F ");
                        } else if (ss[i][j] == 0) {
                            br.write("0 ");
                        } else {
                            br.write("1 ");
                        }
                    }
                }
                br.newLine();
            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(Wave.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
