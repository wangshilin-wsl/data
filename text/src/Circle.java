/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Circle.java
 * @Description TODO
 * @createTime 2021年05月26日 12:50:00
 */
public class Circle extends Point{
    private double r;

    public Circle() {
    }

    public Circle(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
