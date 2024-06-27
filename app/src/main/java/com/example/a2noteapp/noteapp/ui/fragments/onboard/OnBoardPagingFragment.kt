package com.example.a2noteapp.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a2noteapp.R
import com.example.a2noteapp.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize()= with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 ->{
                onTxt.text = "Очень удобный функционал"
                lottieAnimation.setAnimation(R.raw.lottie1)
            }

            1 ->{
                onTxt.text = "Быстрый, качественный продукт"
                lottieAnimation.setAnimation(R.raw.lottie1)
            }

            2 ->{
                onTxt.text = "Куча функций и интересных фишек"
                lottieAnimation.setAnimation(R.raw.lottie1)
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}