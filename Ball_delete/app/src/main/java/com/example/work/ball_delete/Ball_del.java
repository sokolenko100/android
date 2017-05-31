package com.example.work.ball_delete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by work on 19.02.2017.
 */

public class Ball_del extends View
{
    private Paint paint=null;
    ArrayList<Ball> balls=null;
    int HeightD=0;
    int WidthD=0;
    List<Ball> list =null;
    public Ball_del(Context context)
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
        public Ball(float x, float y)
        {
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
        public void moveBall()
        {
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
                Ball ball = new Ball(x,y);
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
