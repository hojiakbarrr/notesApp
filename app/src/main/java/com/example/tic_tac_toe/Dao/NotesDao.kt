package com.example.tic_tac_toe.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.tic_tac_toe.Model.Notes

@Dao
interface NotesDao {


    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=5")
    fun getYellow(): LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=3")
    fun getRed(): LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getBlue(): LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=4")
    fun getViolet(): LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getGreen(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertNote(note : Notes)

    @Query("DELETE from Notes where id ==:NoteId")
    fun deleteNotes(NoteId : String)

    @Update
    fun updateNote (note : Notes)



}