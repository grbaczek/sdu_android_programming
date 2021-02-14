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
class CustomSwipeView : View, GestureDetector.OnGestureListener {

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
    private lateinit var paint: Paint

    constructor(context: Context?) : super(context)

    @SuppressLint("ClickableViewAccessibility")
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setOnTouchListener { _, event ->
            gestureDetector?.onTouchEvent(event)
            Log.i("CustomSwipeView", "onTouchListener")
            true
        }
        gestureDetector = GestureDetector(getContext(), this)
        paint = Paint()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDown(e: MotionEvent?): Boolean {
        return false
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
        if (velocityX > 0) {
            currentColorIndex--
        } else if (velocityX < 0) {
            currentColorIndex++
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
