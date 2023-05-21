package com.snake;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game_Panel extends JPanel implements Runnable,KeyListener{



    public int DRIECTION=38;//刚开始的时候 让小蛇向上移动
    public boolean alive=true;//判断小蛇是否死亡的
    Random ran=new Random();//用来产生Food 的随机坐标



    LinkedList<Snake> snake=new LinkedList<Snake>();
    Food food=new Food(new Point(ran.nextInt(Game_Frame.width/20)*20,ran.nextInt(Game_Frame.height/20)*20));


    public Game_Panel() {

        snake.add(new Snake(new Point(180,180)));//初始化一个蛇头
        this.addKeyListener(this);
        this.setFocusable(true);


    }


    public void  paint(Graphics g) {
        for(int i=0;i<this.snake.size();i++) {
            this.snake.get(i).drawSnake(g);
        }
        this.food.drawFood(g);

        validate();
    }

    public void Snake_Move() { //控制蛇的移动


        if(alive)  { //当小蛇活着的时候 移动  死了就不动了

            switch(this.DRIECTION) {

                case 37:
                    snake.add(new Snake(new Point(snake.getLast().point.x-20,snake.getLast().point.y)));
                    if(snake.getLast().point.x<0) //当小蛇超过窗口范围则从另一边出来，下面同理
                        snake.getLast().point.x=Game_Frame.width-snake.getLast().width;
                    break;
                case 39:
                    snake.add(new Snake(new Point(snake.getLast().point.x+20,snake.getLast().point.y)));
                    if(snake.getLast().point.x==Game_Frame.width)
                        snake.getLast().point.x=0;
                    break;
                case 38:
                    snake.add(new Snake(new Point(snake.getLast().point.x,snake.getLast().point.y-20)));
                    if(snake.getLast().point.y<0)
                        snake.getLast().point.y=Game_Frame.height-snake.getLast().height;
                    break;
                case 40:
                    snake.add(new Snake(new Point(snake.getLast().point.x,snake.getLast().point.y+20)));
                    if(snake.getLast().point.y==Game_Frame.height)
                        snake.getLast().point.y=0;
                    break;

                default: ;

            }
            if(changeSize()) snake.removeFirst();	//如果遇到食物，则不删除第一个结点

        }

    }


    public boolean changeSize() {//当蛇的格子和食物相撞时 ,为false
        if(snake.getLast().point.equals(food.point)){
            food.point.x=ran.nextInt(Game_Frame.width/20)*20;
            food.point.y=ran.nextInt(Game_Frame.height/20)*20;
            return false;
        }
        else return true;

    }


    public void dead() { //小蛇死亡的条件   当头与身相撞的时候宣布死亡
        for(int i=0;i<this.snake.size()-1;i++) {
            if(this.snake.getLast().point.equals(this.snake.get(i).point)) {
                alive=false;//终止线程
                //如果小蛇死了，则弹出对话框
                JOptionPane.showMessageDialog(this, "oh，I'm sorry,you dead!!", "GAME--OVER", JOptionPane.WARNING_MESSAGE);
                //Thread.currentThread().stop();//当小蛇死了线程终止  //stop(),不用这个方法
            }
        }
    }


    public void run() {//调用这些方法

        while(alive) {//如果小蛇活着则循环，否则终止循环即结束线程
            // dead();
            //changeSize();
            Snake_Move();
            //changeSize();
            dead();
            repaint();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void keyPressed(KeyEvent e) {//键盘控制上下左右移动
        //System.out.println(e.getKeyCode());   //经过测试 37 38 39 40  65 87 68 83分别为键盘的左上右下 awds
        switch (e.getKeyCode()) {

            case 37:
                this.DRIECTION=37; //左

                break;
            case 38:
                this.DRIECTION=38;//上

                break;
            case 39:
                this.DRIECTION=39;//右

                break;
            case 40:
                this.DRIECTION=40;	//下

                break;
     /*  case 65://本来准备用wsad和上下左右一起控制小蛇的移动的，但是徒增麻烦没有必要
 			this.DRIECTION=37; //左

 		break;
         case 87:
         	this.DRIECTION=38;//上

 		break;
         case 68:
         	this.DRIECTION=39;//右
         break;
          case 83:
         	 this.DRIECTION=40;	//下
         	 break;

*/
            default: ;

        }
    }


    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

}