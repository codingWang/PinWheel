package com.lib;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by 杜伟 on 2016/2/19.
 */
public class PinWheelDialog {

    private Context mContext;
    private Dialog mDialog;
    private PinWheelView mLoadingView;
    private View mDialogContentView;


    public PinWheelDialog(Context context) {
        this.mContext=context;
        init();
    }

    private void init() {
        mDialog = new Dialog(mContext, R.style.custom_dialog);
        mDialogContentView= LayoutInflater.from(mContext).inflate(R.layout.pinwheel_dialog,null);
        mLoadingView= (PinWheelView) mDialogContentView.findViewById(R.id.pinwheelview);
        mDialog.setContentView(mDialogContentView);
    }

    public void show(){
        mDialog.show();
    }

    public void dismiss(){
        mDialog.dismiss();
    }

    public Dialog getDialog(){
        return  mDialog;
    }

    public void setCanceledOnTouchOutside(boolean cancel){
        mDialog.setCanceledOnTouchOutside(cancel);
    }
}
