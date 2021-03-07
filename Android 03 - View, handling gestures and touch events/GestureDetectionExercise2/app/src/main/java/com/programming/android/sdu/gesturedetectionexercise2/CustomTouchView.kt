package com.programming.android.sdu.gesturedetectionexercise2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable
import androidx.core.view.GestureDetectorCompat

/**
 * Created by grzegorzbaczek on 23/02/2018.
 */
class CustomTouchView(context: Context?, @Nullable attrs: AttributeSet?) : View(context, attrs), GestureDetector.OnGestureListener {

    var circle_paint: Paint = Paint()
    private var mDetector: GestureDetectorCompat? = null
    private val top_left_color = Color.RED
    private val top_right_color = Color.GREEN
    private val bottom_left_color = Color.BLUE
    private val bottom_right_color = Color.YELLOW

    init {
        circle_paint.style = Paint.Style.FILL
        circle_paint.color = Color.WHITE
        mDetector = GestureDetectorCompat(getContext(), this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (mDetector!!.onTouchEvent(event)) {
            return true
        }
        return super.onTouchEvent(event)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val left_top_paint = Paint()
        val left_top = Rect(0, 0, width / 2, height / 2)
        val right_top = Rect(width / 2, 0, width, height / 2)
        val bottom_left = Rect(0, height / 2, width / 2, height)
        val bottom_right = Rect(width / 2, height / 2, width, height)
        val border_paint = Paint()
        border_paint.style = Paint.Style.STROKE
        border_paint.color = Color.BLACK
        border_paint.strokeWidth = 6f
        left_top_paint.style = Paint.Style.FILL
        left_top_paint.color = top_left_color
        canvas?.drawRect(left_top, left_top_paint)
        canvas?.drawRect(left_top, border_paint)
        val right_top_paint = Paint()
        right_top_paint.style = Paint.Style.FILL
        right_top_paint.color = top_right_color
        canvas?.drawRect(right_top, right_top_paint)
        canvas?.drawRect(right_top, border_paint)
        val left_bottom_paint = Paint()
        left_bottom_paint.style = Paint.Style.FILL
        left_bottom_paint.color = bottom_left_color
        canvas?.drawRect(bottom_left, left_bottom_paint)
        canvas?.drawRect(bottom_left, border_paint)
        val right_bottom_paint = Paint()
        right_bottom_paint.style = Paint.Style.FILL
        right_bottom_paint.color = bottom_right_color
        canvas?.drawRect(bottom_right, right_bottom_paint)
        canvas?.drawRect(bottom_right, border_paint)
        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), width * 0.2f, circle_paint)
        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), width * 0.2f, border_paint)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        val w = width
        val h = height
        val half_w = w / 2
        val half_h = h / 2
        if (e != null) {
            if (e.x <= half_w && e.y <= half_h) {
                circle_paint.color = top_left_color
            } else if (e.x > half_w && e.y < half_h) {
                circle_paint.color = top_right_color
            } else if (e.x <= half_w && e.y >= half_h) {
                circle_paint.color = bottom_left_color
            } else if (e.x > half_w && e.y > half_h) {
                circle_paint.color = bottom_right_color
            }
        }
        invalidate()
        return true
    }

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {}

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false
    }

}
