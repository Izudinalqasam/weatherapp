package com.example.weatheapp.Utils

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import com.example.weatheapp.R

class CustomTextView : TextView {
    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
        proccessAtributes(attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ): super (context, attrs, defStyleAttr, defStyleRes)

    private var mainText = ""
    private var customview = false

    fun proccessAtributes(attrs: AttributeSet?){
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_atribut, 0, 0)

            try {
                checkAttribut(typedArray)
            }catch (e: Exception){
                Log.d("CustomView", e.message)
            }finally {
                typedArray.recycle()
            }
        }
    }

    fun checkAttribut(array: TypedArray){
        for (i in 0..array.indexCount){
            when(array.getIndex(i)){
                R.styleable.custom_atribut_custom_strong -> {
                    customview = array.getBoolean(array.getIndex(i), false)
                    addCopyright()
                }
                else -> {}
            }
        }
    }

    fun addCopyright(){
        mainText = text.toString()
        if (customview){
            text = "$mainText -- by Izzuddin"
        }
    }
}
