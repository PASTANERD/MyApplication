package com.example.a0xbistrot.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View {// 커스텀 뷰를 생성하기 위한 웨이

    Canvas mCanvas;
    Bitmap mBitmap;
    Paint mPaint = new Paint();

    int imageNo = 1;
    int oldX = 0;
    int oldY = 0;

    public void setImageNo(int imageNo) {
        this.imageNo = imageNo;
    }

    @Override // View의 사이즈를 사용자 환경에 맞게 조정하는 함수
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);
    }

    public MyCanvas(Context context) {
        super(context);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) { // xml에서 인식하기 위한 생성자
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        Paint paint = new Paint();
//        if(x1 > 0 && y1 > 1){
//            paint.setColor(Color.DKGRAY);
//            paint.setTextSize(30);
//            Bitmap img;
//            if(imageNo == 1) img = BitmapFactory.decodeResource(getResources(), R.drawable.spaghetti);
//            else if(imageNo == 2) img = BitmapFactory.decodeResource(getResources(), R.drawable.chicken);
//            else img = BitmapFactory.decodeResource(getResources(), R.drawable.bears);
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(imageNo == 4) {
            int X = (int) event.getX();
            int Y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    if (oldX != -1) {
                        mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                        invalidate();
                    }
                    oldX = -1;
                    oldY = -1;
                    break;

                case MotionEvent.ACTION_DOWN:
                    oldX = X;
                    oldY = Y;
                    break;

                case MotionEvent.ACTION_MOVE:
                    if (oldX != -1) {
                        mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                        invalidate();
                    }
                    oldX = X;
                    oldY = Y;
                    break;
            }
        }

        else if (imageNo < 4){
            Bitmap img;
            if(imageNo == 1) img = BitmapFactory.decodeResource(getResources(), R.drawable.spaghetti);
            else if(imageNo == 2) img = BitmapFactory.decodeResource(getResources(), R.drawable.chicken);
            else img = BitmapFactory.decodeResource(getResources(), R.drawable.bears);
            mCanvas.drawBitmap(img, (int) event.getX(), (int) event.getY(), null);
            invalidate();
        }
            return true;


    }
}