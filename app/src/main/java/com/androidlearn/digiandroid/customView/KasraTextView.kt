package com.androidlearn.digiandroid.customView

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Typeface
import android.util.AttributeSet

class KasraTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setFont(context)
    }

    private fun setFont(context: Context) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/BHoma.ttf")
        setTypeface(typeface)
    }
}