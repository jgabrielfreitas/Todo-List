package com.kotlin.todolist.fragments

import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.jgabrielfreitas.layoutid.fragments.InjectLayoutBaseFragment
import com.kotlin.todolist.R
import kotlinx.android.synthetic.main.fragment_slide.*

/**
 * Created by JGabrielFreitas on 06/11/16.
 */
@InjectLayout(layout = R.layout.fragment_slide)
class SlideFragment : InjectLayoutBaseFragment {

    constructor() {
    }

    constructor(title: String) : super() {

        titleTextView.text = title
    }
}
