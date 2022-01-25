package com.example.tic_tac_toe.ui.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.ViewModel.NotesViewModel
import com.example.tic_tac_toe.databinding.FragmentIsCheckBinding
import com.example.tic_tac_toe.databinding.FragmentIscheckEditBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*


class IscheckEdit : Fragment() {


    val oldNotes by navArgs<EditsNoteFragmentArgs>()
    lateinit var binding: FragmentIscheckEditBinding
    private lateinit var selectedColor: String
    val viewModel: NotesViewModel by viewModels()
    private lateinit var priority: String
    var isClicked: Boolean = false
    var isClicked2: Int = R.drawable.check_empty
    lateinit var isS: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIscheckEditBinding.inflate(layoutInflater, container, false)


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
            updateNotes(it)
        }


        binding.checkbox1.setOnClickListener {

            if (!isClicked) {
                isClicked = true
                binding.checkbox1.setImageResource(R.drawable.check_not_empty)
            } else {
                isClicked = false
                binding.checkbox1.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox2.setOnClickListener {


            if (!isClicked) {
                isClicked = true
                binding.checkbox2.setImageResource(R.drawable.check_not_empty)
            } else {
                isClicked = false
                binding.checkbox2.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox3.setOnClickListener {

            if (!isClicked) {
                isClicked = true
                binding.checkbox3.setImageResource(R.drawable.check_not_empty)
            } else {
                isClicked = false
                binding.checkbox3.setImageResource(R.drawable.check_empty)
            }
        }


        binding.checkbox4.setOnClickListener {

            if (!isClicked) {
                isClicked = true
                binding.checkbox4.setImageResource(R.drawable.check_not_empty)
            } else {
                isClicked = false
                binding.checkbox4.setImageResource(R.drawable.check_empty)
            }
        }

        binding.checkbox5.setOnClickListener {
            if (!isClicked) {
                isClicked = true
                binding.checkbox5.setImageResource(R.drawable.check_not_empty)
            } else {
                isClicked = false
                binding.checkbox5.setImageResource(R.drawable.check_empty)
            }
        }




        return binding.root

    }

    private fun updateNotes(it: View?) {

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



        val note = Notes()
        note.id = oldNotes.data.id
        note.TitleCheck = title
        note.chekText_1 = text1
        note.chekText_2 = text2
        note.chekText_3 = text3
        note.chekText_4 = text4
        note.chekText_5 = text5
        note.notesDate = time
        note.notesType = 2

        if(!isClicked){
            note.chek1 = R.drawable.check_not_empty
        }else{
            note.chek1 = R.drawable.check_empty
        }

        if(!isClicked){
            note.chek2 = R.drawable.check_not_empty
        }else{
            note.chek2 = R.drawable.check_empty
        }

        if(!isClicked){
            note.chek3 = R.drawable.check_not_empty
        }else{
            note.chek3 = R.drawable.check_empty
        }

        if(!isClicked){
            note.chek4 = R.drawable.check_not_empty
        }else{
            note.chek4 = R.drawable.check_empty
        }

        if(!isClicked){
            note.chek5 = R.drawable.check_not_empty
        }else{
            note.chek5 = R.drawable.check_empty
        }


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

            viewModel.updateNote(note)
            Toast.makeText(requireActivity(), "check note is update", Toast.LENGTH_SHORT).show()

            Navigation.findNavController(it!!)
                .navigate(R.id.action_ischeckEdit_to_homeFragment)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_item, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){


            val bottomSheet : BottomSheetDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetStyle )
            bottomSheet.setContentView(R.layout.dialog_delete)


            val textViewYes = bottomSheet.findViewById<TextView>(R.id.dialog_yes)
            val textViewNo = bottomSheet.findViewById<TextView>(R.id.dialog_no)


            textViewYes?.setOnClickListener {
                viewModel.deleteNotes(oldNotes.data.id.toString())
                Log.i("perehod", "true")
                Toast.makeText(requireActivity(), "note is deleted", Toast.LENGTH_SHORT).show()

//                val action = IscheckEditDirections.actionIscheckEditToHomeFragment()
//                Navigation.findNavController(it).navigate(action)

            }

            textViewNo?.setOnClickListener {
                bottomSheet.dismiss()
            }

            bottomSheet.show()


        }


        return super.onOptionsItemSelected(item)
    }

}
