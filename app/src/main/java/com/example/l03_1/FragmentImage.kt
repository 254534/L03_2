package com.example.l03_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

private const val ARG_PARAM1 = "param1"

class FragmentImage : Fragment() {
    private val imageArr: IntArray = intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4)
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: ImageView = view.findViewById(R.id.imageViewNoContent)
        imageView.setImageResource(imageArr[param1!!])
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    companion object {
        @JvmStatic fun newInstance(param1: Int) =
                FragmentImage().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM1, param1)
                    }
                }
    }
}