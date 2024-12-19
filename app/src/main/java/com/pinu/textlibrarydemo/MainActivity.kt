package com.pinu.textlibrarydemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pinu.textlibrarydemo.databinding.ActivityMainBinding
import com.pinu.textmodifier.TextModifier

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        * Spannable Usage: Spannable is a class used for text content that cannot be changed (immutable),
        * but allows markup objects like styles, colors, and other formatting to be dynamically attached or removed.
        * */
        val textModifier = TextModifier.instance
        val str = "Pankti Prajapati"
        val text1 = textModifier.underlineText(str)
        val text2 = textModifier.strikeThroughText(str)
        val text3 = textModifier.makeItalic(str)
        val text4 = textModifier.makeBold(str)
        val text5 = textModifier.changeTextSize(str, sizeInSp = 16f)
        val text6 = textModifier.changeTextColor(this, str, R.color.purple)

        mBinding.tv1.text = text1
        mBinding.tv2.text = text2
        mBinding.tv3.text = text3
        mBinding.tv4.text = text4
        mBinding.tv5.text = text5
        mBinding.tv6.text = text6
    }
}