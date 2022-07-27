package com.tasas.matias.tasas.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class WorkSans_Medium extends androidx.appcompat.widget.AppCompatTextView {

    public WorkSans_Medium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public WorkSans_Medium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSans_Medium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Medium.ttf");
            setTypeface(tf);
        }
    }

}