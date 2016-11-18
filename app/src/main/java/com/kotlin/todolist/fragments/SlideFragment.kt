package com.kotlin.todolist.fragments

import android.support.v4.content.ContextCompat
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.jgabrielfreitas.layoutid.fragments.InjectLayoutBaseFragment
import com.kotlin.todolist.R
import kotlinx.android.synthetic.main.fragment_slide.*

/**
 * Created by JGabrielFreitas on 06/11/16.
 */
@InjectLayout(layout = R.layout.fragment_slide)
class SlideFragment(title: String, content: String, drawable: Int, color: Int) : InjectLayoutBaseFragment() {

    var title    : String = ""
    var content  : String = ""
    var drawable : Int    = 0
    var color    : Int    = 0

    init {
        this.title    = title
        this.content  = content
        this.drawable = drawable
        this.color    = color
    }

    override fun onStart() {
        super.onStart()
        titleTextView.text   = title
        contentTextView.text = content
        introImageView.setImageDrawable(ContextCompat.getDrawable(activity, drawable))
        rootLinearLayout.setBackgroundColor(ContextCompat.getColor(activity, color))
    }

}
