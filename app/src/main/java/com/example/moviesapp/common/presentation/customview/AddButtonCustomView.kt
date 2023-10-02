package com.example.moviesapp.common.presentation.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.dpToPx

class AddButtonCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
):View(context,attrs, defStyleAttr) {

    private var btnText = ""

    private val linePaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = Color.parseColor("#70FFFFFF")
        strokeWidth = context.dpToPx(2f)
    }

    private val backGroundPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
//        color = ContextCompat.getColor(context,R.color.body_grey)
        color = Color.parseColor("#8014171C")
    }

    private val circleArcPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        strokeWidth = context.dpToPx(3f)
        color = Color.parseColor("#502C343F")
    }

    private val progressPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = Color.WHITE
        strokeWidth = context.dpToPx(2f)
    }

    private val buttonRect = RectF()

    private var offSet: Float = 0f

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddButtonCustomView)
        btnText = typedArray.getString(R.styleable.AddButtonCustomView_btn_text) ?: ""
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        buttonRect.apply {
            top = 0f
            left = 0f + offSet
            right = measuredWidth.toFloat() - offSet
            bottom = measuredHeight.toFloat()
        }

        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val circleRadius = measuredWidth/2f

        val startX = measuredWidth.times(0.3f)
        val startY = measuredHeight.times(0.5).toFloat()
        val endX = measuredWidth.times(0.7f)
        val endY = measuredHeight.times(0.5).toFloat()

        val startVerticalX = measuredWidth.times(0.5f)
        val endVerticalX = measuredWidth.times(0.5f)
        val startVerticalY = measuredHeight.times(0.3f)
        val endVerticalY = measuredHeight.times(0.7f)

        val startArc = measuredWidth.times(0.05f)
        val endArc = measuredWidth.times(0.95f)
        val topArc = (measuredHeight/2) - circleRadius.times(0.9f)
        val bottomArc = (measuredHeight/2) + circleRadius.times(0.9f)

        val startAngle = 0f
        val sweepAngle = 360f

        canvas?.drawCircle(centerX,centerY,circleRadius,backGroundPaint)
        canvas?.drawLine(startX,startY,endX,endY,linePaint)
        canvas?.drawLine(startVerticalX,startVerticalY,endVerticalX,endVerticalY,linePaint)
        canvas?.drawArc(startArc,topArc,endArc,bottomArc,startAngle,sweepAngle,false,circleArcPaint)
    }

}
