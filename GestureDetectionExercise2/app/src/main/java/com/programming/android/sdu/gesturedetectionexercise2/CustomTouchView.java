package com.programming.android.sdu.gesturedetectionexercise2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/**
 * Created by grzegorzbaczek on 23/02/2018.
 */
public class CustomTouchView extends View implements GestureDetector.OnGestureListener {
    Paint circle_paint = new Paint();
    private GestureDetectorCompat mDetector;
    private int top_left_color = Color.RED;
    private int top_right_color = Color.GREEN;
    private int bottom_left_color = Color.BLUE;
    private int bottom_right_color = Color.YELLOW;

    public CustomTouchView(Context context) {
        super(context);
    }
    public CustomTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        circle_paint.setStyle(Paint.Style.FILL);
        circle_paint.setColor(Color.WHITE);
        mDetector = new GestureDetectorCompat(getContext(),this);
    }
    public CustomTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public CustomTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint left_top_paint = new Paint();
        Rect left_top = new Rect(0, 0, getWidth() / 2, getHeight() / 2);
        Rect right_top = new Rect(getWidth() / 2, 0, getWidth() , getHeight() / 2);
        Rect bottom_left = new Rect(0, getHeight() / 2, getWidth() / 2 , getHeight() );
        Rect bottom_right = new Rect(getWidth() / 2, getHeight() / 2, getWidth() , getHeight() );
        Paint border_paint = new Paint();
        border_paint.setStyle(Paint.Style.STROKE);
        border_paint.setColor(Color.BLACK);
        border_paint.setStrokeWidth(6f);
        left_top_paint.setStyle(Paint.Style.FILL);
        left_top_paint.setColor(top_left_color);
        canvas.drawRect(left_top, left_top_paint);
        canvas.drawRect(left_top, border_paint);
        Paint right_top_paint = new Paint();
        right_top_paint.setStyle(Paint.Style.FILL);
        right_top_paint.setColor(top_right_color);
        canvas.drawRect(right_top, right_top_paint);
        canvas.drawRect(right_top, border_paint);
        Paint left_bottom_paint = new Paint();
        left_bottom_paint.setStyle(Paint.Style.FILL);
        left_bottom_paint.setColor(bottom_left_color);
        canvas.drawRect(bottom_left, left_bottom_paint);
        canvas.drawRect(bottom_left, border_paint);
        Paint right_bottom_paint = new Paint();
        right_bottom_paint.setStyle(Paint.Style.FILL);
        right_bottom_paint.setColor(bottom_right_color);
        canvas.drawRect(bottom_right, right_bottom_paint);
        canvas.drawRect(bottom_right, border_paint);
        canvas.drawCircle(getWidth() /2, getHeight() /2 ,getWidth() * 0.2f, circle_paint);
        canvas.drawCircle(getWidth() /2, getHeight() /2 ,getWidth() * 0.2f, border_paint);
    }
    @Override
    public boolean onDown(MotionEvent e) {
        int w = getWidth();
        int h = getHeight();
        int half_w = w/2;
        int half_h = h/2;
        if(e.getX() <= half_w && e.getY() <= half_h ){
            circle_paint.setColor(top_left_color);
        }
        else if(e.getX() > half_w && e.getY() < half_h ){
            circle_paint.setColor(top_right_color);
        }
        else if(e.getX() <= half_w && e.getY() >= half_h ){
            circle_paint.setColor(bottom_left_color);
        }
        else if(e.getX() > half_w && e.getY() > half_h ){
            circle_paint.setColor(bottom_right_color);
        }
        invalidate();
        return true;
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
        return false;
    }
}