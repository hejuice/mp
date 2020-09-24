package com.example.touchtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }

    class MyView extends View {

        float x,y;
        private String str;

        Paint paint = new Paint();
        Path path = new Path();

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.YELLOW);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(10f);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }
        //오른쪽마우스, generate, overidemethod 검색
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x= event.getX();
            y= event.getY();

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                path.moveTo(x,y);
            }
            else if(event.getAction() == MotionEvent.ACTION_UP){
                str = "ACTION_UP";
            }
            else if(event.getAction() == MotionEvent.ACTION_MOVE){
                str = "ACTION_MOVE";
                path.lineTo(x,y);
            }
            invalidate();   //그림 새로 그려줌

            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPath(path, paint);

            /*
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            float radius;
            canvas.drawCircle(x, y, 100, paint);
            paint.setTextSize(50);
            canvas.drawText("액션의 종류: "+str, 0, 100, paint);
             */
        }
    }

}
