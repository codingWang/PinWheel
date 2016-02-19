package com.lib;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/**
 * Created by 杜伟 on 2016/2/19.
 */
public class PinWheelView extends FrameLayout {

    private PinWheel mPinWheel;

    public PinWheelView(Context context) {
        super(context);
    }

    public PinWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PinWheelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //填充view
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pinwheelview, null);
        //布局参数
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //居中
        layoutParams.gravity = Gravity.CENTER;
        //找到View
        mPinWheel = (PinWheel) view.findViewById(R.id.pinwheel);
        //添加到布局
        addView(view, layoutParams);
        startAnim(200);//延迟900毫秒开启动画
    }

    private void startAnim(long delay) {
        if (delay>0){
            this.postDelayed(mAnimRunnable,delay);
        }
    }
    private Runnable mAnimRunnable = new Runnable() {
        @Override
        public void run() {
            rotate();
        }
    };

    private void rotate(){
        ObjectAnimator rotateAnim =ObjectAnimator.ofFloat(mPinWheel, "rotation", 0, -360);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setDuration(800);
        rotateAnim.setRepeatCount(-1);
        rotateAnim.start();
    }

}
