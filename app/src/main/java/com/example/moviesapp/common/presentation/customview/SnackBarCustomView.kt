package com.example.moviesapp.common.presentation.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.dpToPx
import kotlin.math.min

class SnackBarCustomView(
    context: Context,
    attrs: AttributeSet? = null,
):View(context,attrs){

    private var text = ""

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SnackBarCustomView)
        text = typedArray.getString(R.styleable.SnackBarCustomView_text) ?: ""
        typedArray.recycle()
    }

    private val rect = RectF()

    private val backgroundPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        color = context.getColor(R.color.red)
    }

    private val textPaint = Paint().apply {
        color = context.getColor(R.color.transparent_grey)
        textSize = context.dpToPx(16f)
        textAlign = Paint.Align.CENTER
        typeface = ResourcesCompat.getFont(context,R.font.poppins_medium)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val desiredWidth = measuredWidth
        val desiredHeight = 50

        val width = when(widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> min(desiredWidth,widthSize)
            else -> desiredWidth
        }

        val height = when(heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> min(heightSize,desiredHeight)
            else -> desiredHeight
        }

        setMeasuredDimension(width,height)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {

        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()
        val cX = canvasWidth/2f
        val cY = canvasHeight/2f

        val cR = 50f

        rect.apply {
            top = 0f
            left = 0f
            right = canvasWidth
            bottom = canvasHeight
        }

        canvas.drawRoundRect(rect,cR,cR,backgroundPaint)
        canvas.drawText(text,cX,cY,textPaint)

        super.onDraw(canvas)
    }

}
