package com.kun.hack3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 16-6-5.
 */
public class CascadeLayout extends ViewGroup {

    private int mHorizontalSpacing;
    private int mVerticalSpacing;
    private List<Point> points;

    public CascadeLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CascadeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CascadeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CascadeLayout);
        mHorizontalSpacing = array.getDimensionPixelSize(R.styleable.CascadeLayout_horizontal_spacing,
                getResources().getDimensionPixelSize(R.dimen.cascade_horizontal_spacing));
        mVerticalSpacing = array.getDimensionPixelSize(R.styleable.CascadeLayout_vertical_spacing,
                getResources().getDimensionPixelSize(R.dimen.cascade_vertical_spacing));
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getPaddingLeft();
        int height = getPaddingTop();
        final int count = getChildCount();
        points = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            points.add(new Point(width, height));
            width += mHorizontalSpacing;
            height += mVerticalSpacing;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            Point point = points.get(i);
            child.layout(point.x, point.y, child.getWidth() + point.x, child.getHeight() + point.y);
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        int x;
        int y;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

    }
}
