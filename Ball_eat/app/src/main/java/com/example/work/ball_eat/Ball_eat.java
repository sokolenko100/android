package com.example.work.ball_eat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Ball_eat extends View
{
    private Paint paint=null;
    ArrayList<Ball> balls=null;
    int HeightD=0;
    int WidthD=0;
    List<Ball> list =null;
    public Ball_eat(Context context)
    {
        super(context);
        paint = new Paint();
        balls = new ArrayList<>();
        list = Collections.synchronizedList(balls);
        paint.setStyle(Paint.Style.FILL);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    invalidate();
            }
        },5);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        HeightD = w;
        WidthD = h;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        synchronized(list)
        {
            Iterator<Ball> iterator = list.iterator();
            while (iterator.hasNext()) {
                Ball b = iterator.next();
                b.draw(canvas);
            }
            canvas.restore();
            invalidate();
        }
    }

    public class Ball
    {
        int x;
        int y;
        int dx;
        int dy;
        int color ;
        int r =20;
        int colors[] = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED,
                Color.CYAN, Color.LTGRAY, Color.BLACK, Color.YELLOW, Color.RED};
        Random rnd = null;
        List<Ball> list = null;
        public Ball(float x, float y,List<Ball> list)
        {
            this.list = list;
            rnd = new Random();
            this.x=(int)x;
            this.y=(int)y;
            SetColor();
            SetRadius();
            int speed =  SetSpeed();
            dx = speed;
            dy = speed;
            SetDemention();
        }
        private void SetColor()
        {
            color= colors[rnd.nextInt(9)];
        }
        private void SetRadius()
        {
             r= 20+rnd.nextInt(50-20);
        }
        private int SetSpeed()
        {
            int speed=0;
            speed = 2+rnd.nextInt(17-2);
            return speed;
        }
        private void SetDemention()
        {
            if(0== rnd.nextInt(2))
            {
                dx =-dx;
            }
            if(0==rnd.nextInt(2))
            {
                dy =-dy;
            }
        }

         public void draw(Canvas canvas)
         {
             moveBall();
             paint.setColor(color);
             canvas.drawCircle(x, y, r, paint);
         }
        private  boolean ChaeckBall( int x_this,int y_this,int r_this,int x_ball,int y_ball,int r_ball)
        {
            double dist = Math.sqrt(Math.pow(x_ball - x_this, 2) + Math.pow(y_ball - y_this, 2));
            return r_ball+r_this >= Math.sqrt(dist)  ? true : false;
        }
        public void moveBall()
        {
//            synchronized(list) {
//                for (Iterator<Ball> iter = list.iterator(); iter.hasNext(); ) {
//                    Ball b2 = iter.next();
//                    if (ChaeckBall(x, y,r, b2.x, b2.y, b2.r))
//                    {
//                        if(this.r>b2.r)
//                        {
//                            this.r +=b2.r;
//                            if(this.r>500)
//                            {
//                                Creat_8_ball( x,  y,  r, list);
//                            }
//                            iter.remove();
//                        }
//                    }
//                }
//            }
            if(x>=(HeightD-r)||x<=r)
            {
                if(x>=HeightD-r)
                {
                   x=HeightD-(r+1);
                }
                if(x<=r)
                {
                    x=(r+1);
                }
                this.dx=-dx;
            }
            if(y>=(WidthD-r)||y<=r)
            {
                if(y>=WidthD-r)
                {
                   y=WidthD-(r+1);

                }
                if(y<=r)
                {
                    y=r+1;
                }
                this.dy=-dy;
            }
            x +=dx;
            y +=dy;
        }
    }
    public void eat_ball(int rad)
    {

    }
    public void Creat_8_ball(int x, int y, int r, List<Ball> list)
    {
        for (int i =0; i<8;i++)
        {
            Ball ball = new Ball(x,y,list);
            ball.r =r/2;
            list.add(ball);
        }

    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        float x = e.getX();
        float y = e.getY();
        boolean flag = true;
        if(e.getAction() == MotionEvent.ACTION_DOWN)
          {
              synchronized(list) {
                  for (Iterator<Ball> iter = list.iterator(); iter.hasNext(); ) {
                      Ball b2 = iter.next();
                      if (TouchChaeckBall(x, y, b2.x, b2.y, b2.r)) {
                          iter.remove();
                          flag = false;
                      }
                  }
              }
              if(flag)
              {
                  Ball ball = new Ball(x,y,list);
                  list.add(ball);
              }
          }
        return true;
    }
    private  boolean TouchChaeckBall( float x_Touch,float y_Touch,int x_ball,int y_ball,int r_ball)
    {
        double dist = Math.sqrt(Math.pow(x_ball - x_Touch, 2) + Math.pow(y_ball - y_Touch, 2));
        return r_ball >= dist  ? true : false;
    }
}
