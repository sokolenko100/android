package com.example.task_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RelativeLayout contentMain;
    RelativeLayout relativeLayout;
    Paint paint;
    View view;
    Path path2;
    Bitmap bitmap;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentMain = (RelativeLayout) findViewById(R.id.activity_main);
        view = new SketchSheetView(MainActivity.this);

        paint = new Paint();
        path2 = new Path();

        contentMain.addView(view, new ActionBar.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        paint.setDither(true);

        paint.setColor(Color.parseColor("#000000"));

        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeJoin(Paint.Join.ROUND);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setStrokeWidth(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();


        if (id == R.id.action_save)
        {
            return true;
        }
        else if (id == R.id.action_load)
        {
            return true;
        }
        else if (id == R.id.action_color)
        {
            return true;
        }
        else if (id == R.id.action_stroke)
        {
            return true;
        }
        else if (id == R.id.action_clear)
        {
            path2.reset();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class SketchSheetView extends View
    {
        public SketchSheetView(Context context)
        {
            super(context);

            bitmap = Bitmap.createBitmap(700, 480, Bitmap.Config.ARGB_4444);

            canvas = new Canvas(bitmap);

            this.setBackgroundColor(Color.WHITE);
        }

        ArrayList<DrawingClass> DrawingClassArrayList = new ArrayList<DrawingClass>();

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            DrawingClass pathWithPaint = new DrawingClass();

            canvas.drawPath(path2, paint);
            if(event.getAction() == MotionEvent.ACTION_DOWN)
            {
                path2.moveTo(event.getX(), event.getY());

                path2.lineTo(event.getX(), event.getY());
            }
            else if (event.getAction() == MotionEvent.ACTION_MOVE)
            {
                path2.lineTo(event.getX(),event.getY());

                pathWithPaint.setPath(path2);

                pathWithPaint.setPaint(paint);

                DrawingClassArrayList.add(pathWithPaint);
            }
            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            if(DrawingClassArrayList.size() > 0)
            {
                canvas.drawPath(
                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPath(),
                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPaint());
            }
            super.onDraw(canvas);
        }
    }

    public class DrawingClass
    {
        Path DrawingClassPath;
        Paint DrawingClassPaint;

        public Path getPath()
        {
            return DrawingClassPath;
        }

        public void setPath(Path path)
        {
            this.DrawingClassPath = path;
        }

        public Paint getPaint()
        {
            return DrawingClassPaint;
        }

        public void setPaint(Paint paint)
        {
            this.DrawingClassPaint = paint;
        }
    }


}
