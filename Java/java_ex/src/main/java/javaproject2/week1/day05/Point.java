package javaproject2.week1.day05;

public class Point {
    int x;
    int y;
    boolean isSameXy() {
        return x == y;
    }
    double getDistance(Point p2) {
        int xL = p2.x - this.x;
        int yL = p2.y - this.y;

        double sumOfPow = Math.pow(xL, 2) + Math.pow(yL, 2);
        double result = Math.sqrt(sumOfPow);

        return result;
    }
}
