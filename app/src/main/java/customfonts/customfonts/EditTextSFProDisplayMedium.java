package com.tasas.matias.tasas.common.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextSFProDisplayMedium extends EditText {
    public EditTextSFProDisplayMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextSFProDisplayMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextSFProDisplayMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SF-Pro-Display-Medium.otf");
            setTypeface(tf);
        }
    }

}
