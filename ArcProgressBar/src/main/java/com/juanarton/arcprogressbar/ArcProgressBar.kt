package com.juanarton.arcprogressbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View

class ArcProgressBar(context: Context, attributes: AttributeSet) : View(context, attributes) {
    private var progressArc = Paint()
    private var trackArc = Paint()

    private val progressRectf = RectF()

    private var progressWidth = 20f
    private var trackWidth = 20f

    private var progressColor = Color.parseColor("#7084ff")
    private var trackColor = Color.parseColor("#676767")

    private var progressValue = 50f
    private var progressMax = 100f
    private var progressMin = 0f
    private var progressValueTmp = 50f

    private var startAngle = 140f
    private var sweepAngle = 260f

    init {
        progressArc.style = Paint.Style.STROKE
        trackArc.style = Paint.Style.STROKE

        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.ArcProgressBar)
        try {
            progressColor = typedArray.getColor(R.styleable.ArcProgressBar_progressColor, progressColor)
            progressWidth = typedArray.getDimension(R.styleable.ArcProgressBar_progressWidth, progressWidth)

            trackColor = typedArray.getColor(R.styleable.ArcProgressBar_trackColor, trackColor)
            trackWidth = typedArray.getDimension(R.styleable.ArcProgressBar_trackWidth, trackWidth)

            startAngle = typedArray.getFloat(R.styleable.ArcProgressBar_startAngle, startAngle)
            sweepAngle = typedArray.getFloat(R.styleable.ArcProgressBar_sweepAngle, sweepAngle)

            progressMax = typedArray.getFloat(R.styleable.ArcProgressBar_progressMax, progressMax)
            progressMin = typedArray.getFloat(R.styleable.ArcProgressBar_progressMin, progressMin)
            progressValueTmp = typedArray.getFloat(R.styleable.ArcProgressBar_progress, progressValue)
            progressValue = scale(typedArray.getFloat(R.styleable.ArcProgressBar_progress, progressValue), sweepAngle, progressMax, progressMin)
            Log.d("test", progressValue.toString())
        } finally {
            typedArray.recycle()
        }

        progressArc.strokeWidth = progressWidth
        progressArc.color = progressColor

        trackArc.strokeWidth = trackWidth
        trackArc.color = trackColor

        progressArc.strokeCap = Paint.Cap.ROUND
        trackArc.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        Log.d("start", startAngle.toString())
        Log.d("sweep", sweepAngle.toString())
        canvas.drawArc(progressRectf, startAngle, sweepAngle, false, trackArc)

        if (progressValueTmp in progressMin..progressMax) {
            canvas.drawArc(progressRectf, startAngle, progressValue, false, progressArc)
        }
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 200
        val desiredHeight = 200

        val width = resolveSize(desiredWidth, widthMeasureSpec)
        val height = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(width, height)

        val maxStrokeWidth = trackArc.strokeWidth.coerceAtLeast(progressArc.strokeWidth)
        progressRectf.set(
            maxStrokeWidth / 2,
            maxStrokeWidth / 2,
            width.toFloat() - maxStrokeWidth / 2,
            height.toFloat() - maxStrokeWidth / 2
        )
    }

    private fun scale(value: Float, sweepAngle: Float, progressMax: Float, progressMin: Float): Float {
        return ((value - progressMin) * (sweepAngle - 0)) / (progressMax - progressMin)
    }

    var progress: Float
        get() = progressValue
        set(value) {
            progressValue = scale(value, sweepAngle, progressMax, progressMin)
            invalidate()
        }
}