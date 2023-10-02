package com.example.moviesapp.common.presentation.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.dpToPx
import kotlin.math.min

class BurgerButtonCustomView constructor(
    context: Context,
    attrs:AttributeSet
):View(context,attrs){

    private val backgroundRect = RectF()
    private val cornerRadius = context.dpToPx(0f)

    private val backgroundPaint = Paint().apply {
        isAntiAlias = false
        style = Paint.Style.FILL
        color = ContextCompat.getColor(context,R.color.darker_header_grey)
    }

    private val linePaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = context.getColor(R.color.white)
        strokeWidth = context.dpToPx(2f)
    }

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BurgerButtonCustomView)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val reqWidth = MeasureSpec.getSize(widthMeasureSpec)
        val reqWidthMode = MeasureSpec.getMode(widthMeasureSpec)

        val reqHeight = MeasureSpec.getSize(heightMeasureSpec)
        val reqHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        val desiredWidth = 30
        val desiredHeight = 40

        val width = when(reqWidthMode) {
            MeasureSpec.EXACTLY -> reqWidth
            MeasureSpec.UNSPECIFIED -> desiredWidth
            else -> min(reqWidth,desiredWidth)
        }

        val height = when(reqHeightMode) {
            MeasureSpec.EXACTLY -> reqHeight
            MeasureSpec.UNSPECIFIED -> desiredHeight
            else -> min(reqHeight,desiredHeight)
        }

        setMeasuredDimension(width,height)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {

        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()

        backgroundRect.apply{
            top = 0f
            left = 0f
            right = canvasWidth
            bottom = canvasHeight
        }

        val centerX = measuredWidth/2f
        val centerY = measuredHeight/2f
        val circleRadius = measuredWidth/2f

        canvas?.drawCircle(centerX,centerY,circleRadius,backgroundPaint)
        canvas?.drawRoundRect(backgroundRect,cornerRadius,cornerRadius,backgroundPaint)

        val startX = canvasWidth.times(0.15f)
        val stopX = canvasWidth.times(0.85f)

        val y1 = canvasHeight.times(0.35f)

        canvas?.drawLine(startX,y1,stopX,y1,linePaint)

        val y2 = canvasHeight.times(0.5f)

        canvas?.drawLine(startX,y2,stopX,y2,linePaint)

        val y3 = canvasHeight.times(0.65f)

        canvas?.drawLine(startX,y3,stopX,y3,linePaint)

        super.onDraw(canvas)
    }
}
