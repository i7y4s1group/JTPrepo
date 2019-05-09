package pl.labs.lab1;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(7, 12);
        Line l1 = new Line(p1, p2);
        l1.save();
        System.out.println(l1);
    }
}
