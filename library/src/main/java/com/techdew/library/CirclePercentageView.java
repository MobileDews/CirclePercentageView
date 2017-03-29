package com.techdew.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by techdew-007 on 16/2/17.
 */

public class CirclePercentageView extends View {
    int base_color;
    int percentage_color;
    public CirclePercentageView(Context context) {
        super(context);
        init();
    }
    public CirclePercentageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomWidget);
        base_color = a.getResourceId(R.styleable.MyCustomWidget_base_color, -1);
        percentage_color= a.getResourceId(R.styleable.MyCustomWidget_percentage_color, -1);
        init();
    }
    public CirclePercentageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomWidget);
        base_color = a.getResourceId(R.styleable.MyCustomWidget_base_color, -1);
        percentage_color= a.getResourceId(R.styleable.MyCustomWidget_percentage_color, -1);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), base_color));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        bgpaint = new Paint();
        bgpaint.setColor(ContextCompat.getColor(getContext(),percentage_color));
        bgpaint.setAntiAlias(true);
        bgpaint.setStyle(Paint.Style.FILL);
        rect = new RectF();
    }
    Paint paint;
    Paint bgpaint;
    RectF rect;
    float percentage = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = 0;
        int width = getWidth();
        int top = 0;
        rect.set(left, top, left+width, top + width);
        canvas.drawArc(rect, -90, 360, true, bgpaint);
        if(percentage!=0) {
            canvas.drawArc(rect, -90, (360*percentage), true, paint);
        }
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage / 100;
        invalidate();
    }
}
