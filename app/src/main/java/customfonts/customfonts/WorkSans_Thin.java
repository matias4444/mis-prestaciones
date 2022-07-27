package com.tasas.matias.tasas.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class WorkSans_Thin extends androidx.appcompat.widget.AppCompatTextView {

    public WorkSans_Thin(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public WorkSans_Thin(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSans_Thin(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Thin.ttf");
            setTypeface(tf);
        }
    }

}
