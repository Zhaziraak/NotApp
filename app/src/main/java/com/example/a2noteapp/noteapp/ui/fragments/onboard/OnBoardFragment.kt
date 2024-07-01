package com.example.a2noteapp.noteapp.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.a2noteapp.R
import com.example.a2noteapp.databinding.FragmentOnBoardBinding
import com.example.a2noteapp.noteapp.ui.adapters.OnBoardViewPagerAdapter
import com.example.a2noteapp.noteapp.utils.SharedPreference
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
        setupListeners()
        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
        }.attach()
        startWork()
    }


    private fun initialize() {
        binding.viewpager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
        SharedPreference.unit(requireContext())
    }

    private fun setupListeners() = with(binding.viewpager2) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position < 3) {
                    binding.txtSkip.setOnClickListener {
                        setCurrentItem(currentItem + 2, true)
                    }
                }
                binding.txtStart.setOnClickListener {
                    findNavController().navigate(R.id.noteFragment)
                }
                when (position) {
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

    private fun startWork() {
        binding.txtStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment, null,
                /*navOptions {
                    anim {
                        enter = R.anim.rotate_anim
                    }
                }*/)
        }
        saveSharPref()
    }

    private fun saveSharPref() {
        SharedPreference.isBoard = true
    }
}


/* <TextView
        android:id="@+id/txt_save"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="24sp" />

    <Button
        android:id="@+id/btn_save"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Save"
        android:textSize="16sp" />*

         <Button
        android:id="@+id/btn_action"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="->"
        android:textSize="16sp" />/
 */