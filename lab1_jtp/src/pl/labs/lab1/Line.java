package pl.labs.lab1;

import java.io.FileWriter;
import java.io.IOException;

public class Line {
    private  Point p1;
    private  Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setPoint1(Point p1) { this.p1 = p1; }

    public void setPoint2(Point p2) {
        this.p2 = p2;
    }

    public Point getPoint1() {
        return p1;
    }

    public Point getPoint2() {
        return p2;
    }

    public void move(int nx, int ny){
        p1.move(nx,ny);
        p2.move(nx,ny);
    }

    public void flip(){
        p1.flip();
        p2.flip();
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    public void save(){
        try {
            FileWriter save = new FileWriter("line.txt", true);
            save.append(toString() + System.getProperty("line.separator"));
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
