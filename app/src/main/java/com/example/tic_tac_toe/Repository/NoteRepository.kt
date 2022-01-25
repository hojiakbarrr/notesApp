package com.example.tic_tac_toe.Repository

import android.provider.LiveFolders
import androidx.lifecycle.LiveData
import com.example.tic_tac_toe.Dao.NotesDao
import com.example.tic_tac_toe.Model.Notes

class NoteRepository (val dao: NotesDao){

    fun getAllNotes(): LiveData<List<Notes>> = dao.getNotes()

    fun getYellowNotes(): LiveData<List<Notes>> = dao.getYellow()
    fun getRedNotes(): LiveData<List<Notes>> = dao.getRed()
    fun getVioletNotes(): LiveData<List<Notes>> = dao.getViolet()
    fun getBlueNotes(): LiveData<List<Notes>> = dao.getBlue()
    fun getGreenNotes(): LiveData<List<Notes>> = dao.getGreen()


    fun insertNotes(notes: Notes){
        dao.InsertNote(notes)
    }

    fun deleteNotes(id: String){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNote(notes)
    }

}