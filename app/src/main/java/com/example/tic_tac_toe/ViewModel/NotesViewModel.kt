package com.example.tic_tac_toe.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tic_tac_toe.DataBase.NoteDataBase
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.Repository.NoteRepository

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val repository: NoteRepository

    init {
        val dao = NoteDataBase.getDatabaseInstance(application).mynotesDao()
        repository = NoteRepository(dao)
    }

    fun AddNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun getYellowNotes(): LiveData<List<Notes>> = repository.getYellowNotes()
    fun getRedNotes(): LiveData<List<Notes>> = repository.getRedNotes()
    fun getVioletNotes(): LiveData<List<Notes>> = repository.getVioletNotes()
    fun getBlueNotes(): LiveData<List<Notes>> = repository.getBlueNotes()
    fun getGreenNotes(): LiveData<List<Notes>> = repository.getGreenNotes()

    fun deleteNotes(id: String){
        repository.deleteNotes(id)
    }

    fun updateNote(notes: Notes){
        repository.updateNotes(notes)
    }
}