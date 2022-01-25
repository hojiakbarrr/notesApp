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
import com.example.tic_tac_toe.databinding.FragmentEditsNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*


class EditsNoteFragment : Fragment() {

    val oldNotes by navArgs<EditsNoteFragmentArgs>()
    lateinit var binding: FragmentEditsNoteBinding
    private lateinit var changeColor: String
    private lateinit var priority: String
    val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEditsNoteBinding.inflate(layoutInflater,container,false)
        setHasOptionsMenu(true)


        binding.editTitle.setText(oldNotes.data.notesTitle)
        binding.editText.setText(oldNotes.data.notesText)
        binding.EditTime.setText(oldNotes.data.notesDate)


        binding.pwBlue.setOnClickListener {
            binding.pwBlue.setImageResource(R.drawable.ic_all)
            binding.pwGreen.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            changeColor = "blue"
            priority = "1"
        }

        binding.pwGreen.setOnClickListener {
            binding.pwGreen.setImageResource(R.drawable.ic_all)
            binding.pwBlue.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            changeColor = "Green"
            priority = "2"

        }
        binding.pwRed.setOnClickListener {
            binding.pwRed.setImageResource(R.drawable.ic_all)
            binding.pwBlue.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.wYellow.setImageResource(0)
            binding.pwGreen.setImageResource(0)
            changeColor = "Red"
            priority = "3"

        }
        binding.pwViolet.setOnClickListener {
            binding.pwViolet.setImageResource(R.drawable.ic_all)
            binding.wYellow.setImageResource(0)
            binding.pwRed.setImageResource(0)
            binding.pwGreen.setImageResource(0)
            binding.pwBlue.setImageResource(0)
            changeColor = "Violet"
            priority = "4"

        }
        binding.wYellow.setOnClickListener {
            binding.wYellow.setImageResource(R.drawable.ic_all)
            binding.pwGreen.setImageResource(0)
            binding.pwViolet.setImageResource(0)
            binding.pwBlue.setImageResource(0)
            binding.pwRed.setImageResource(0)
            changeColor = "Yellow"
            priority = "5"

        }


        binding.btnEditFab.setOnClickListener {
            updateNotes(it)
        }






        return binding.root
    }

    private fun updateNotes(it: View?) {

        val currentDate: String = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())
        val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        /////*/*/*/*/*/*/

        val title = binding.editTitle.text.toString()
        val text = binding.editText.text.toString()
        var time = binding.EditTime.text.toString()
        val second =   currentDate + " " + currentTime
        time = second

        val note = Notes()
        note.id = oldNotes.data.id
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
            note.backgroundColor = setColor(changeColor)
        } catch (e: Exception) {
            note.backgroundColor = R.drawable.blue_dot
        }


        if (note.notesText.isNotEmpty()&&note.notesTitle.isNotEmpty()){
            viewModel.updateNote(note)

            Toast.makeText(requireActivity(), "changes is save", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it!!).navigate(R.id.action_editsNoteFragment_to_homeFragment)

        }else{
            Toast.makeText(requireActivity(), "поля пустые ", Toast.LENGTH_SHORT).show()

        }


//        toHome(it)


    }

    private fun setColor(changeColor: String): Int {

        return when (changeColor) {
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
                R.color.white
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

//               toHome(it)

//               bottomSheet.dismiss()

//               Navigation.findNavController(it!!).navigate(R.id.action_editsNoteFragment_to_homeFragment)

           }

           textViewNo?.setOnClickListener {
               bottomSheet.dismiss()
           }

           bottomSheet.show()


       }


        return super.onOptionsItemSelected(item)
    }

    private fun toHome(it: View?) {

        Navigation.findNavController(it!!).navigate(R.id.action_editsNoteFragment_to_homeFragment)

    }
}