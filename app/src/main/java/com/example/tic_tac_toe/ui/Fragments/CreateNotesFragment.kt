package com.example.tic_tac_toe.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.ViewModel.NotesViewModel
import com.example.tic_tac_toe.databinding.FragmentCreateNotesBinding
import java.text.SimpleDateFormat
import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    private lateinit var selectedColor: String
    val viewModel: NotesViewModel by viewModels()
    private lateinit var priority: String
    var whit2 = R.color.white
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binding.pBlue.setOnClickListener {
            binding.pBlue.setImageResource(R.drawable.ic_all)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
            binding.pViolet.setImageResource(0)
            binding.pYellow.setImageResource(0)
            selectedColor = "blue"
            priority = "1"
        }
        binding.pGreen.setOnClickListener {
            binding.pGreen.setImageResource(R.drawable.ic_all)
            binding.pBlue.setImageResource(0)
            binding.pRed.setImageResource(0)
            binding.pViolet.setImageResource(0)
            binding.pYellow.setImageResource(0)
            selectedColor = "Green"
            priority = "2"

        }
        binding.pRed.setOnClickListener {
            binding.pRed.setImageResource(R.drawable.ic_all)
            binding.pBlue.setImageResource(0)
            binding.pViolet.setImageResource(0)
            binding.pYellow.setImageResource(0)
            binding.pGreen.setImageResource(0)
            selectedColor = "Red"
            priority = "3"

        }
        binding.pViolet.setOnClickListener {
            binding.pViolet.setImageResource(R.drawable.ic_all)
            binding.pYellow.setImageResource(0)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
            binding.pBlue.setImageResource(0)
            selectedColor = "Violet"
            priority = "4"


        }
        binding.pYellow.setOnClickListener {
            binding.pYellow.setImageResource(R.drawable.ic_all)
            binding.pGreen.setImageResource(0)
            binding.pViolet.setImageResource(0)
            binding.pBlue.setImageResource(0)
            binding.pRed.setImageResource(0)
            selectedColor = "Yellow"
            priority = "5"
        }


        binding.btnCreatFab.setOnClickListener {
            creatNotes(it)

        }

        return binding.root
    }

    private fun creatNotes(it: View?) {
        val currentDate: String = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())
        val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        /////*/*/*/*/*/*/


        val title = binding.edittitle.text.toString()
        val text = binding.editText.text.toString()
        var time = binding.time.text.toString()
        val second = currentDate + " " + currentTime
        time = second

        val note = Notes()

        note.notesDate = time
        note.notesText = text
        note.notesTitle = title
        note.notesType = 1
        try {
            note.priority = priority
        } catch (e: Exception) {
            note.priority = "1"
        }
        try {
            note.backgroundColor = setColor(selectedColor)
        } catch (e: Exception) {
            note.backgroundColor = R.drawable.blue_dot
        }

        if (note.notesText.isNotEmpty()&&note.notesTitle.isNotEmpty()){

            viewModel.AddNotes(note)
            Toast.makeText(requireActivity(), "note is created", Toast.LENGTH_SHORT).show()


            Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
        }else{
            Toast.makeText(requireActivity(), "поля пустые", Toast.LENGTH_SHORT).show()
        }






    }

    private fun setColor(selectedColor: String): Int {
        return when (selectedColor) {
            "blue" -> {
                R.drawable.blue_dot
            }
            "Green" -> {
                R.drawable.green_dot
            }
            "Red" -> {
                R.drawable.red_dot
            }
            "Violet" -> {
                R.drawable.violet_dot
            }
            "Yellow" -> {
                R.drawable.yellow_dot
            }

            else -> {
                R.drawable.white_dot
            }
        }
    }
//        "Green" -> R.drawable
//
//
//
//        when (data.backgroundColor) {
////            R.drawable.blue_dot -> {
////                holder.binding.TemaFona.setBackgroundColor(R.drawable.blue_dot)
////                holder.binding.Oval.setBackgroundResource(R.drawable.blue_dot)
////
////            }
////            "2" -> {
////                holder.binding.TemaFona.setBackgroundColor(R.drawable.green_dot)
////                holder.binding.Oval.setBackgroundResource(R.drawable.green_dot)
////
////            }
//        }


}