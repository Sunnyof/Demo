package com.sun.game.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Heart extends View {
    public Heart(Context context) {
        super(context);
    }

    public Heart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Heart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(false);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);

        Path path = new Path();
        path.moveTo(120,300);
        path.cubicTo(110,220,150,200,300,300);
//        path.quadTo(150,200,300,300);
        path.cubicTo(300,300,150,400,110,220);
        canvas.drawPath(path,paint);
    }
}
