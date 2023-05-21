package com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Snake {


    public Point point=null; //一直蛇其实就是一个小格子

    public  final int width=20;
    public  final int height=20;

    public Snake(Point p) {
        this.point=p;
    }

    public void drawSnake(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.point.x,this.point.y, this.width,this.height);

    }

}