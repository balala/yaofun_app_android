//package com.balala.yaofun.util;
//
//import android.content.Context;
//import android.view.MotionEvent;
//import android.view.View;
//
//public class ZoomImageView extends View {
//    public ZoomImageView(Context context) {
//        super(context);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (initRatio == totalRatio) {
//            getParent().requestDisallowInterceptTouchEvent(false);
//        } else {
//            getParent().requestDisallowInterceptTouchEvent(true);
//        }
//        return true;
//    }
//
//}
