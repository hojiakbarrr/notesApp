package com.example.tic_tac_toe.DataBase

import android.content.Context
import androidx.room.*
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.Dao.NotesDao

@Database (entities = [Notes :: class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase()  {


    abstract fun mynotesDao(): NotesDao

    companion object {
        @Volatile
        var INSTANCE: NoteDataBase? = null

        fun getDatabaseInstance(context: Context): NoteDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDataBaseinstance = Room.databaseBuilder(context,
                    NoteDataBase::class.java, "Notes"
                ).allowMainThreadQueries().build()
                INSTANCE = roomDataBaseinstance
                return return roomDataBaseinstance
            }

        }

    }



}
