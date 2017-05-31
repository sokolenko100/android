package com.example.artyom.simple_paint;

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
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class PaintActivity extends AppCompatActivity
{
    RelativeLayout contentMain;
    RelativeLayout relativeLayout;
    Paint paint;
    View view;
    Path path2;
    Bitmap bitmap;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mein_menu,menu);

        contentMain = (RelativeLayout) findViewById(R.id.paint);
        view = new SketchSheetView(PaintActivity.this);
        paint = new Paint();
        path2 = new Path();

        contentMain.addView(view, new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        paint.setDither(true);
        paint.setColor(Color.parseColor("#000000"));
        paint.setStyle();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id==R.id.action_save)
    {

    }
        if (id==R.id.action_clear)
        {

        }
        if (id==R.id.action_color)
        {

        }
        if (id==R.id.action_stroke)
        {

        }
        if (id==R.id.action_Load)
        {

        }
    }

    private ArrayList<DrowingClass> DrowingClasArrayList = new ArrayList<DrowingClass>();
    class SketchSheetView extends View
    {


        public SketchSheetView(Context context)
        {
            super(context);
            bitmap = Bitmap.createBitmap(820,480,Bitmap.Config.ARGB_4444);
            canvas = new Canvas();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            return super.onTouchEvent(event);

            DrowingClass pathWithPaint = new DrowingClass();
            canvas.drawPath(path2,paint);
            if(event.getAction()==MotionEvent.ACTION_DOWN)
            {
                path2.moveTo(event.getX(),event.getY());
                path2.lineTo(event.getX(),event.getY());
            }
            else if(event.getAction()==MotionEvent.ACTION_MOVE)
            {
                path2.lineTo(event.getX(),event.getY());
                pathWithPaint.setPath(path2);
                pathWithPaint.setPaint(paint);
                DrowingClasArrayList.add(pathWithPaint);
            }
            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            if (DrowingClasArrayList.size()>0)
            {
             canvas.drawPath(
                     DrowingClasArrayList.get(DrowingClasArrayList.size()-1).getPath(),
                     DrowingClasArrayList.get(DrowingClasArrayList.size()-1).getPaint()
             );
            }
        }
    }

    public  class DrowingClass
    {
       Path DrawingClassPath;
        Paint  DrawingClassPaint;
       public Path getPath()
       {
           return  DrawingClassPath;
       }
        public void setPath(Path path)
        {
            this.DrawingClassPath =path;
        }
        public Paint getPaint()
        {
            return  DrawingClassPaint;
        }
        public void setPaint(Paint paint)
        {
            this.DrawingClassPaint = paint;
        }
    }
}
