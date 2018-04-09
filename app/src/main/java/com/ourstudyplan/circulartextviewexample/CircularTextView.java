package com.ourstudyplan.circulartextviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

public class CircularTextView extends android.support.v7.widget.AppCompatTextView {

    private float mStrokeWidth = 0.0f;
    private int mStrokeColor;
    private int mSolidColor;

    Paint circlePaint;
    Paint strokePaint;

    private static final String TAG = CircularTextView.class.getSimpleName();

    public CircularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircularTextView,
                0, 0);

        try {
            mStrokeWidth = a.getDimension(R.styleable.CircularTextView_strokeWidth, 0.0f);
            mStrokeColor = a.getColor(R.styleable.CircularTextView_strokeColor, getResources().getColor(R.color.black));
            mSolidColor = a.getColor(R.styleable.CircularTextView_solidColor, getResources().getColor(R.color.black));
        } finally {
            a.recycle();
        }

        init();
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        strokePaint = new Paint();
        strokePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
         int diameter, radius, height, width;

        circlePaint.setColor(mSolidColor);
        strokePaint.setColor(mStrokeColor);



        height = getHeight();
        width = getWidth();

        Log.d(TAG, "onDraw: "+width+" "+height);

        diameter = ((height > width) ? height : width);
        radius = diameter / 2;

        canvas.drawCircle(diameter / 2, diameter / 2, radius, strokePaint);
        canvas.drawCircle(diameter / 2, diameter / 2, radius - mStrokeWidth, circlePaint);
        super.onDraw(canvas);
    }

    public float getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int dp) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        this.mStrokeWidth = dp * scale;
    }

    public int getStrokeColor() {
        return mStrokeColor;
    }

    public void setStrokeColor(int mStrokeColor) {
        this.mStrokeColor = mStrokeColor;
    }

    public int getSolidColor() {
        return mSolidColor;
    }

    public void setSolidColor(int mSolidColor) {
        this.mSolidColor = mSolidColor;
    }
}
