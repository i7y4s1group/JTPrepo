package pl.labs.lab1;

public class Line {
    private Point points[] = new Point[2];

    Line(Point point1, Point point2) {
        setLine(point1, point2);
    }

    public void move(int xValue, int yValue) {
        points[0].move(xValue, yValue);
        points[1].move(xValue, yValue);
    }

    public void flip() {
        points[0].flip();
        points[1].flip();
    }

    private int[] getFirstValues() {
        return points[0].getPoint();
    }

    private int[] getSecondValues() {
        return points[1].getPoint();
    }

    public String toString() {
        return "Linia{" + " p1 = " + points[0].toString() + ", p2 = " + points[1].toString() + " }";
    }

    public Point[] getLine() {
        return points;
    }

    private void setLine(Point point1, Point point2) {
        points[0] = point1;
        points[1] = point2;
    }
}
