package com.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 杜伟 on 2016/2/19.
 */
public class PinWheel extends View {

    private Paint mPaint;
    private Path mPath;
    private int mWidth,mHeight;

    public PinWheel(Context context) {
        super(context);
        init();
    }

    public PinWheel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PinWheel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.dialog_bg));
        mWidth = getWidth();
        mHeight = getHeight();

        mPath.moveTo(mWidth,mHeight/2);//画右边的梯形
        mPath.lineTo(mWidth/2,mHeight/2);
        mPath.lineTo(mWidth/2,mHeight/3);
        mPath.lineTo(3*mWidth/4,mHeight/3);
        mPath.close();
        canvas.drawPath(mPath,mPaint);

        canvas.save();                  //画下边的梯形
        mPaint.reset();
        mPaint.setColor(Color.RED);
        canvas.rotate(90,mWidth/2,mHeight/2);
        canvas.drawPath(mPath,mPaint);
        canvas.restore();

        canvas.save();                  //画左边的梯形
        mPaint.reset();
        mPaint.setColor(Color.GREEN);
        canvas.rotate(180,mWidth/2,mHeight/2);
        canvas.drawPath(mPath,mPaint);
        canvas.restore();

        canvas.save();                  //画上边的梯形
        mPaint.reset();
        mPaint.setColor(Color.parseColor("#ffcc01"));
        canvas.rotate(270,mWidth/2,mHeight/2);
        canvas.drawPath(mPath,mPaint);
        canvas.restore();
    }
}
