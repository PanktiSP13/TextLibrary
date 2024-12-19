package com.pinu.textmodifier
import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.*
import androidx.core.content.ContextCompat

/**
 * TextModifier is a utility class with various text modification methods.
 */
class TextModifier private constructor() {

    companion object {
        val instance: TextModifier by lazy { TextModifier() }
    }

    /**
     * Applies bold styling to a given text.
     */
    fun makeBold(text: String): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Applies italic styling to a given text.
     */
    fun makeItalic(text: String): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(StyleSpan(Typeface.ITALIC), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Applies underline styling to a given text.
     */
    fun underlineText(text: String): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(UnderlineSpan(), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Changes the color of the text.
     */
    fun changeTextColor(context: Context, text: String, colorResId: Int): SpannableString {
        val spannable = SpannableString(text)
        val color = ContextCompat.getColor(context, colorResId)
        spannable.setSpan(ForegroundColorSpan(color), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Applies a strike-through effect to the text.
     */
    fun strikeThroughText(text: String): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(StrikethroughSpan(), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Changes the font size of the text.
     */
    fun changeTextSize(text: String, sizeInSp: Float): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(AbsoluteSizeSpan(sizeInSp.toInt(), true), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }

    /**
     * Combines multiple text modifications.
     */
    fun applyMultipleStyles(
        context: Context,
        text: String,
        isBold: Boolean = false,
        isItalic: Boolean = false,
        isUnderline: Boolean = false,
        isStrikeThrough: Boolean = false,
        colorResId: Int? = null,
        sizeInSp: Float? = null
    ): SpannableString {
        val spannable = SpannableString(text)

        if (isBold) spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        if (isItalic) spannable.setSpan(
            StyleSpan(Typeface.ITALIC),
            0,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        if (isUnderline) spannable.setSpan(
            UnderlineSpan(),
            0,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        if (isStrikeThrough) spannable.setSpan(
            StrikethroughSpan(),
            0,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        colorResId?.let {
            val color = ContextCompat.getColor(context, it)
            spannable.setSpan(ForegroundColorSpan(color), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        sizeInSp?.let {
            spannable.setSpan(AbsoluteSizeSpan(it.toInt(), true), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        return spannable
    }
}
