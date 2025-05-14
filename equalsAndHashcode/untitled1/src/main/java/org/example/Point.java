package org.example;

public class Point {
    public double height;
    public double width;

    public double getX() {
        return height;
    }

    public void setX(final double x) {
        if (x < 0) throw new IllegalArgumentException("");
        this.height = x;
    }

    public double getY() {
        return width;
    }

    public void setY(final double y) {
        if (y < 0) throw new IllegalArgumentException("");
        this.width = y;
    }
}
