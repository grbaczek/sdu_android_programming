package com.programming.android.sdu.gesturedetectionexercise1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.DKGRAY;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

/**
 * Created by grzegorzbaczek on 23/02/2018.
 */

public class CustomSwipeView extends View implements GestureDetector.OnGestureListener {

    private final int[] colors = {
            BLACK,
            DKGRAY,
            GRAY,
            LTGRAY,
            WHITE,
            RED,
            GREEN,
            BLUE,
            YELLOW,
            CYAN,
            MAGENTA
    };
    private  int current_color_index;

    private GestureDetector gestureDetector;

    public CustomSwipeView(Context context) {
        super(context);
    }

    public CustomSwipeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                Log.i("CustomSwipeView", "onTouchListener");
                return true;
            }
        });
        gestureDetector = new GestureDetector(getContext(), this);
    }

    public CustomSwipeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSwipeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (velocityX > 0) {
            current_color_index--;
        } else if (velocityX < 0) {
            current_color_index++;
        }
        if (current_color_index >= colors.length) {
            current_color_index = colors.length -1;
        }
        if (current_color_index < 0) {
            current_color_index = 0;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(colors[current_color_index]);
        p.setStyle(Paint.Style.FILL);
        canvas.drawPaint(p);

    }
}
