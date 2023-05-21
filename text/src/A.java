class Point {
    private double x;
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point point) {
        double xPoor = this.x - point.getX();
        double yPoor = this.y - point.getY();
        return Math.sqrt(xPoor * xPoor + yPoor * yPoor);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class A {

    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 4);
        System.out.println("这两点之间的距离为:" + point1.distance(point2));
    }

}