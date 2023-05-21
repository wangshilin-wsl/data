package com.snake;

import javax.swing.*;

public class Game_Frame extends JFrame {
    public final static int  width=400;
    public  final static int  height=400;
    Game_Panel myPanel=null;

    public static void main(String[] args) {
        new	Game_Frame();

    }

    public Game_Frame() {
        this.setTitle("贪吃蛇");
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game_Panel myPanel=new Game_Panel();
        this.add(myPanel);
        new Thread(myPanel).start();
    }
}