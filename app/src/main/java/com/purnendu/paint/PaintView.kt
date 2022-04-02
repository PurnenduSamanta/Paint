package com.purnendu.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.purnendu.paint.MainActivity.Companion.paintBrush
import com.purnendu.paint.MainActivity.Companion.path

class PaintView : View {


    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initialization()
    }


    private fun initialization() {
        paintBrush.apply {
            isAntiAlias = true
            color = currentBrush
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeWidth = 8f
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        val x: Float = event.x
        val y: Float = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
            }


            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                pathList.add(path)
                colorList.add(currentBrush)
                invalidate()
            }
            else -> return false

        }
        return true
    }

    override fun onDraw(canvas: Canvas?) {

        for (i in pathList.indices) {
            paintBrush.color = colorList[i]
            canvas?.drawPath(pathList[i], paintBrush)
            invalidate()
        }


    }


}