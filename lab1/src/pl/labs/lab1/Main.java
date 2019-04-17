package pl.labs.lab1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Point points[] = new Point[2];
        points[0] = new Point(2, 5);
        points[1] = new Point(3, 2);
        points[0].move(3, 0);
        points[1].flip();
        System.out.println("P1 " + points[0]);
        System.out.println("P2 " + points[1]);

        Line lines[] = new Line[2];
        lines[0] = new Line(new Point(5, 5), new Point(2, 3));
        lines[1] = new Line(new Point(1, 1), new Point(5, 5));
        lines[0].move(3, 4);
        lines[1].flip();
        System.out.println("L1 " + lines[0]);
        System.out.println("L2 " + lines[1]);

        FileWriter fw = null;
        try {
            fw = new FileWriter("file.txt");
            fw.write(points[0].toString() + System.getProperty("line.separator"));
            fw.write(points[1].toString() + System.getProperty("line.separator"));
            fw.write(lines[0].toString() + System.getProperty("line.separator"));
            fw.write(lines[1].toString() + System.getProperty("line.separator"));

        } catch (IOException e) {
            System.err.println("err:" + e.getMessage());
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
