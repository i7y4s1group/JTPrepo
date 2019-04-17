package pl.labs.lab1;

public class Point {
    private int values[] = new int[2];

    Point(int xValue, int yValue) {
        setPoint(xValue, yValue);
    }

    public void move(int xValue, int yValue) {
        values[0] += xValue;
        values[1] += yValue;
    }

    public void flip() {
        values[0] *= -1;
        values[1] *= -1;
    }

    public int[] getPoint() {
        return values;
    }

    public String toString() {
        return "Punkt{ " + "x = " + this.getXValue() + ", y = " + this.getYValue() + " }";
    }

    private int getXValue() {
        return values[0];
    }

    private int getYValue() {
        return values[1];
    }

    private void setPoint(int xValue, int yValue) {
        values[0] = xValue;
        values[1] = yValue;
    }
}
