package com.example.tic_tac_toe.Model

import android.webkit.WebSettings
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    var notesTitle: String = "",
    var TitleCheck: String = "",

    var notesText: String = "",

    var notesDate: String = "",

    var notesType: Int ? = null,

    var backgroundColor: Int = 0,

    var priority: String = "",

    var chek1: Int = 0,
    var chek2: Int = 0,
    var chek3: Int = 0,
    var chek4: Int = 0,
    var chek5: Int = 0,
    var chek6: Int = 0,
    var chek7: Int = 0,

    var chekText_1: String = "",
    var chekText_2: String = "",
    var chekText_3: String = "",
    var chekText_4: String = "",
    var chekText_5: String = "",
    var chekText_6: String = "",
    var chekText_7: String = "",
): Serializable





