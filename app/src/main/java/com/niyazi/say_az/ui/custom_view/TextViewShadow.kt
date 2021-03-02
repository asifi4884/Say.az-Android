package com.niyazi.say_az.ui.custom_view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.ItemLayoutShadowTextViewBinding
import com.niyazi.say_az.utils.extensions.convertDpToPx

/**
 * Created by Niyazi on 12/24/2020.
 */
class TextViewShadow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle) {
    private var start: String? = ""
    private var end: String? = ""
    private var icon: Drawable? = null
    private var binding: ItemLayoutShadowTextViewBinding

    init {
        context.obtainStyledAttributes(attrs, R.styleable.TextViewShadow).apply {
            start = getString(R.styleable.TextViewShadow_startText)
            end = getString(R.styleable.TextViewShadow_endText)
            icon = getDrawable(R.styleable.TextViewShadow_icon)
            recycle()
        }

        binding =
            ItemLayoutShadowTextViewBinding.inflate(LayoutInflater.from(context), this)
        this.radius = resources.convertDpToPx(14f)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            this.outlineAmbientShadowColor = ContextCompat.getColor(context, R.color.colorTeal)
        }
        binding.textViewStart.text = start
        binding.textViewEnd.text = end
        binding.textViewStart.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
    }

    fun changeEndText(value: String) {
        binding.textViewEnd.text = value
    }

    fun getEndText() = binding.textViewEnd.text.toString()
}