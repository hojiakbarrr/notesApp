package com.example.tic_tac_toe.ui.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.ViewModel.NotesViewModel
import com.example.tic_tac_toe.databinding.FragmentHomeBinding
import com.example.tic_tac_toe.ui.Adapter.NoteAdapter

class HomeFragment : Fragment() {


    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(context,
            R.anim.rotate_open_anim)
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(context,
            R.anim.rotate_close_anim)
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(context,
            R.anim.to_botton_anim)
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(context,
            R.anim.from_botton_anim)
    }

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()
    private var clicked: Boolean = false
    var oldMyNotes = arrayListOf<Notes>()
    var oldyNotes = arrayListOf<Notes>()
    lateinit var adapter: NoteAdapter
    var count: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        binding.revAllNotes.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getNotes().observe(viewLifecycleOwner, { noteList ->
            oldMyNotes = noteList as ArrayList<Notes>
            adapter = NoteAdapter(requireContext(), noteList)
            binding.revAllNotes.adapter = adapter
        })


        binding.filterAll.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner, { noteList ->
                oldMyNotes = noteList as ArrayList<Notes>
                adapter = NoteAdapter(requireContext(), oldMyNotes)
                binding.revAllNotes.adapter = adapter
                Log.i("myTag", "asadsasdadaad")
            })
        }
        binding.filterBlue.setOnClickListener {
//            viewModel.getBlueNotes().observe(viewLifecycleOwner, { noteList ->
//
//                adapter = NoteAdapter(requireContext(), noteList)
//                binding.revAllNotes.adapter = adapter
//            })
            oldyNotes.clear()
            count++
            for (o in oldMyNotes) {
                if (o.priority.equals("1")) {
                    oldyNotes.add(o)
                    oldyNotes.size - count
                            adapter = NoteAdapter(requireContext(), oldyNotes)
                    binding.revAllNotes.adapter = adapter
                }
            }

        }
        binding.filterRed.setOnClickListener {
            viewModel.getRedNotes().observe(viewLifecycleOwner, { noteList ->
                oldMyNotes = noteList as ArrayList<Notes>

                adapter = NoteAdapter(requireContext(), oldMyNotes)
                binding.revAllNotes.adapter = adapter
            })
        }
        binding.filterGreen.setOnClickListener {
            viewModel.getGreenNotes().observe(viewLifecycleOwner, { noteList ->
                oldMyNotes = noteList as ArrayList<Notes>
//
                adapter = NoteAdapter(requireContext(), oldMyNotes)
                binding.revAllNotes.adapter = adapter
            })
        }
        binding.filterViolet.setOnClickListener {
            viewModel.getVioletNotes().observe(viewLifecycleOwner, { noteList ->
                oldMyNotes = noteList as ArrayList<Notes>

                adapter = NoteAdapter(requireContext(), oldMyNotes)
                binding.revAllNotes.adapter = adapter
            })
        }
        binding.filterYellow.setOnClickListener {
            viewModel.getYellowNotes().observe(viewLifecycleOwner, { noteList ->

                oldMyNotes = noteList as ArrayList<Notes>

                adapter = NoteAdapter(requireContext(), oldMyNotes)
                binding.revAllNotes.adapter = adapter
            })
        }

        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                NotesFilter(p0)

                return true

            }


        })



        binding.btnAddNotes.setOnClickListener {
            setAnimation(clicked)
            setVisibility(clicked)
            clicked = !clicked

        }

        binding.fab3.setOnClickListener {

/////////////////////note
            val note = Notes(
                notesType = 1
            )


            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)

        }


        binding.fab2.setOnClickListener {
/////////////////////note  is Checked

            val note = Notes(
                notesType = 2
            )

            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_isCheck)
        }

        return binding.root
    }

    private fun NotesFilter(p0: String?) {

        val newFilteredList = arrayListOf<Notes>()

        for (i in oldMyNotes) {
            if (i.notesTitle.contains(p0!!) || i.notesText.contains(p0!!)) {
                newFilteredList.add(i)
            }
        }
        adapter.filtering(newFilteredList)

    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.fab2.visibility = View.VISIBLE
            binding.fab3.visibility = View.VISIBLE
        } else {
            binding.fab2.visibility = View.INVISIBLE
            binding.fab3.visibility = View.INVISIBLE
        }

    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.btnAddNotes.startAnimation(rotateOpen)
            binding.fab3.startAnimation(fromBottom)
            binding.fab2.startAnimation(fromBottom)
        } else {
            binding.btnAddNotes.startAnimation(rotateClose)
            binding.fab3.startAnimation(toBottom)
            binding.fab2.startAnimation(toBottom)
        }

    }

}