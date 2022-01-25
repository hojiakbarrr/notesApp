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
import com.example.tic_tac_toe.databinding.FragmentHomeBinding
import com.example.tic_tac_toe.databinding.FragmentIsCheckBinding
import java.text.SimpleDateFormat
import java.util.*

class IsCheck : Fragment() {

    lateinit var binding: FragmentIsCheckBinding
    private lateinit var selectedColor: String
    val viewModel: NotesViewModel by viewModels()
    private lateinit var priority: String
    var isClicked: Int = R.drawable.check_not_empty
    var isClicked2: Int = R.drawable.check_empty
    lateinit var isS: String

    var click: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentIsCheckBinding.inflate(layoutInflater, container, false)


        binding.pwBlue.setOnClickListener {
            binding.pwBlue.setImageResource(R.drawable.ic_all)
            binding.pwGreen.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            selectedColor = "blue"
            priority = "1"
        }

        binding.pwGreen.setOnClickListener {
            binding.pwGreen.setImageResource(R.drawable.ic_all)
            binding.pwBlue.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            selectedColor = "Green"
            priority = "2"

        }
        binding.pwRed.setOnClickListener {
            binding.pwRed.setImageResource(R.drawable.ic_all)
            binding.pwBlue.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            binding.pwGreen.setImageResource(0)
            selectedColor = "Red"
            priority = "3"

        }
        binding.pwViolet.setOnClickListener {
            binding.pwViolet.setImageResource(R.drawable.ic_all)
            binding.wYellow.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwGreen.setImageResource(0)
            binding.pwBlue.setImageResource(0)
            selectedColor = "Violet"
            priority = "4"

        }
        binding.wYellow.setOnClickListener {
            binding.wYellow.setImageResource(R.drawable.ic_all)
            binding.pwGreen.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.pwBlue.setImageResource(0)
            binding.pwRed.setImageResource(0)
            selectedColor = "Yellow"
            priority = "5"

        }



        binding.btnEditFab.setOnClickListener {
            saveNote(it)
        }


        binding.checkbox1.setOnClickListener {
            val note = Notes()

            if (!click) {
                click = true
//                isClicked
                isS = "box"
                binding.checkbox1.setImageResource(R.drawable.check_not_empty)
            } else {
                click = false
//                isClicked2
                isS = "notbox"
                binding.checkbox1.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox2.setOnClickListener {
            val note = Notes()

            if (!click) {
                click = true
//                isClicked
                isS = "box"
                binding.checkbox2.setImageResource(R.drawable.check_not_empty)
            } else {
                click = false
//                isClicked2
                isS = "notbox"
                binding.checkbox2.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox3.setOnClickListener {
            val note = Notes()

            if (!click) {
                click = true
//                isClicked
                isS = "box"
                binding.checkbox3.setImageResource(R.drawable.check_not_empty)
            } else {
                click = false
//                isClicked
                isS = "notbox"
                binding.checkbox3.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox4.setOnClickListener {
            val note = Notes()

            if (!click) {
                click = true
//                isClicked
                isS = "box"
                binding.checkbox4.setImageResource(R.drawable.check_not_empty)
            } else {
                click = false
//                isClicked
                isS = "notbox"
                binding.checkbox4.setImageResource(R.drawable.check_empty)
            }
        }

        binding.checkbox5.setOnClickListener {
            val note = Notes()

            if (!click) {
                click = true
//                isClicked
                isS = "box"
                binding.checkbox5.setImageResource(R.drawable.check_not_empty)
            } else {
                click = false
//                isClicked
                isS = "notbox"
                binding.checkbox5.setImageResource(R.drawable.check_empty)
            }
        }

        return binding.root


        // Inflate the layout for this fragment
    }

    private fun saveNote(it: View?) {
        val currentDate: String = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())
        val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        var time = binding.EditTime.text.toString()
        val second = currentDate + " " + currentTime
        time = second


        val title = binding.titleCHECK.text.toString()
        val text1 = binding.checkText1.text.toString()
        val text2 = binding.checkText2.text.toString()
        val text3 = binding.checkText3.text.toString()
        val text4 = binding.checkText4.text.toString()
        val text5 = binding.checkText5.text.toString()


//        val note = Notes(
//            TitleCheck = title,
//            chekText_1 = text1,
//            chekText_2 = text2,
//            chekText_3 = text3,
//            chekText_4 = text4,
//            chekText_5 = text5,
//            notesDate = time,
//            chek1 = isClicked,
//            chek2 = isClicked,
//            chek3 = isClicked,
//            chek4 = isClicked,
//            chek5 = isClicked,
//            notesType = 2
//
//        )

        val note = Notes()
        note.TitleCheck = title
        note.chekText_1 = text1
        note.chekText_2 = text2
        note.chekText_3 = text3
        note.chekText_4 = text4
        note.chekText_5 = text5
        note.notesDate = text5

//        if(click){
//            isS = isClicked
//        }else{
//            isS = isClicked2
//        }

        try {
            note.chek1 = setbox(isS)
            note.chek2 = setbox(isS)
            note.chek3 = setbox(isS)
            note.chek4 = setbox(isS)
            note.chek5 = setbox(isS)
        } catch (e: Exception) {
            note.chek1 = isClicked2
            note.chek2 = isClicked2
            note.chek3 = isClicked2
            note.chek4 = isClicked2
            note.chek5 = isClicked2
        }
        note.notesType = 2
        note.notesDate = time


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



        if (note.TitleCheck.isNotEmpty()) {

            viewModel.AddNotes(note)
            Toast.makeText(requireActivity(), "check note is created", Toast.LENGTH_SHORT).show()


            Navigation.findNavController(it!!)
                .navigate(R.id.action_isCheck_to_homeFragment)
        } else {
            Toast.makeText(requireActivity(), "поля пустые", Toast.LENGTH_SHORT).show()
        }


    }


    private fun setColor(selectedColor: String): Int {
        return when (selectedColor) {
            "box" -> {
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

    private fun setbox(iss: String): Int {
        return when (iss) {
            "box" -> {
                R.drawable.check_empty


//                R.drawable.check_not_empty
            }
            "notbox" -> {
                R.drawable.check_not_empty

//                R.drawable.check_empty
            }

            else -> {
                R.drawable.white_dot
            }
        }
    }
}

