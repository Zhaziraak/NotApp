package com.example.a2noteapp.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.a2noteapp.R
import com.example.a2noteapp.databinding.FragmentOnBoardBinding
import com.example.a2noteapp.databinding.FragmentOnBoardPagingBinding
import com.example.a2noteapp.noteapp.ui.adapters.OnBoardViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        TabLayoutMediator(binding.tabLayout, binding.viewpager2) {
            tab, position ->
        }.attach()
    }


    private fun initialize() {
        binding.viewpager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun setupListener() = with(binding.viewpager2){
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if (position < 3){
                    binding.txtSkip.setOnClickListener{
                        setCurrentItem(currentItem + 2, true)
                    }
                }
                binding.txtStart.setOnClickListener{
                    findNavController().navigate(R.id.noteFragment)
                }
                when(position) {
                    0 -> {
                        binding.txtSkip.visibility = View.VISIBLE
                        binding.txtStart.visibility = View.INVISIBLE
                    }

                    1 -> {
                        binding.txtSkip.visibility = View.VISIBLE
                        binding.txtStart.visibility = View.INVISIBLE
                    }

                    2 -> {
                        binding.txtSkip.visibility = View.INVISIBLE
                        binding.txtStart.visibility = View.VISIBLE
                    }
                }
                super.onPageSelected(position)
            }
        })

    }

}