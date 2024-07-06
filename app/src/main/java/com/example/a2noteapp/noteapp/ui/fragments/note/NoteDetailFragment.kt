package com.example.a2noteapp.noteapp.ui.fragments.note

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a2noteapp.R
import com.example.a2noteapp.databinding.FragmentNoteDetailBinding
import com.example.a2noteapp.noteapp.App
import com.example.a2noteapp.noteapp.data.models.NoteModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding
    private var color: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.btn_grey -> color = Color.parseColor("#8E8B8B")
                R.id.btn_beige -> color = Color.parseColor("#EBE4C9")
                R.id.btn_red -> color = Color.parseColor("#571818")
                else -> color = Color.BLACK
            }
        }

        val currentDate = SimpleDateFormat("dd MMMM ", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        binding.txtDate.text = currentDate
        binding.txtTime.text = currentTime

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_noteDetailFragment_to_noteFragment)
        }

        binding.btnDone.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val date = binding.txtDate.text.toString()
            val time = binding.txtTime.text.toString()
            val color = if (color != 0) "#" + Integer.toHexString(color)
                .substring(2) else "#000000"

            App().getInstance()?.noteDao()?.insertNote(
                NoteModel(
                    title, description, date, time, color
                )
            )
            findNavController().navigateUp()
        }
    }
}