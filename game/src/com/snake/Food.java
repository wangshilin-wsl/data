package com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {//食物也是一个长宽各为20的小格子

    public Point point=null;
    public final int width=20;
    public final int height=20;

    public Food(Point p) {
        this.point=p;
    }

    public void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.point.x, this.point.y, this.width, this.height);
    }

}