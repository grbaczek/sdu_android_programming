package com.programming.android.sdu.gesturedetectionexercise1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * Created by grzegorzbaczek on 23/02/2018.
 */
class CustomSwipeView @SuppressLint("ClickableViewAccessibility") constructor(
    context: Context?,
    attrs: AttributeSet?
) : View(context, attrs), GestureDetector.OnGestureListener {

    private val colors: IntArray = intArrayOf(
        Color.BLACK,
        Color.DKGRAY,
        Color.GRAY,
        Color.LTGRAY,
        Color.WHITE,
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA
    )

    private var currentColorIndex = 0
    private var gestureDetector: GestureDetector? = null
    private var paint: Paint

    init {
        setOnTouchListener { _, event ->
            gestureDetector?.onTouchEvent(event)
            Log.i("CustomSwipeView", "onTouchListener")
            true
        }
        gestureDetector = GestureDetector(getContext(), this)
        paint = Paint()
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {}


    private val SWIPE_DISTANCE_THRESHOLD = 100
    private val SWIPE_VELOCITY_THRESHOLD = 100

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {

        val distanceX = e2!!.x - e1!!.x
        val distanceY = e2.y - e1.y
        if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD
        ) {
            if (distanceX > 0) {
                currentColorIndex--
                Log.i("CustomSwipeView", "velocityX > 0")
            } else{
                currentColorIndex++
                Log.i("CustomSwipeView", "velocityX < 0")
            }
        }

        if (currentColorIndex >= colors.size) {
            currentColorIndex = colors.size - 1
        }

        if (currentColorIndex < 0) {
            currentColorIndex = 0
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = colors[currentColorIndex]
        paint.style = Paint.Style.FILL
        canvas?.drawPaint(paint)
    }

}
