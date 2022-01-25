package com.example.tic_tac_toe.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tic_tac_toe.Model.Notes
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.ui.Fragments.HomeFragmentDirections

class NoteAdapter(val context: Context, var noteList: List<Notes>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_SIMPLE = 1
    private val ITEM_CHEK = 2

    fun filtering(newFilteredList: ArrayList<Notes>) {
        noteList = newFilteredList
        notifyDataSetChanged()
    }


    class ChekNotesViewHolder(var holder: View) : RecyclerView.ViewHolder(holder) {
        fun bind(item: Notes) {
            var cgeckBoxText1 = holder.findViewById<TextView>(R.id.check_text1)
            var cgeckBoxText2 = holder.findViewById<TextView>(R.id.check_text2)
            var cgeckBoxText3 = holder.findViewById<TextView>(R.id.check_text3)
            var cgeckBoxText4 = holder.findViewById<TextView>(R.id.check_text4)
            var cgeckBoxText5 = holder.findViewById<TextView>(R.id.check_text5)
            var title = holder.findViewById<TextView>(R.id.Сheck_title)
            var checkTime = holder.findViewById<TextView>(R.id.TimeOfNote)
            var Oval = holder.findViewById<View>(R.id.Oval)
            Oval.setBackgroundResource(item.backgroundColor)

            var box1 = holder.findViewById<ImageView>(R.id.checkbox1)
            box1.setBackgroundResource(item.chek1)
            var box2 = holder.findViewById<ImageView>(R.id.checkbox2)
            box2.setBackgroundResource(item.chek2)
            var box3 = holder.findViewById<ImageView>(R.id.checkbox3)
            box3.setBackgroundResource(item.chek3)
            var box4 = holder.findViewById<ImageView>(R.id.checkbox4)
            box4.setBackgroundResource(item.chek4)
            var box5 = holder.findViewById<ImageView>(R.id.checkbox5)
            box5.setBackgroundResource(item.chek5)

            cgeckBoxText1.setText(item.chekText_1)
            cgeckBoxText2.setText(item.chekText_2)
            cgeckBoxText3.setText(item.chekText_3)
            cgeckBoxText4.setText(item.chekText_4)
            cgeckBoxText5.setText(item.chekText_5)
            checkTime.text = item.notesDate
            title.setText(item.TitleCheck)

//            if (item.chek1 == true) {
//                box1.setImageResource(R.drawable.check_not_empty)
//            } else {
//                box1.setImageResource(R.drawable.check_empty)
//            }
//
//            if (item.chek2 == true) {
//                box2.setImageResource(R.drawable.check_not_empty)
//            } else {
//                box2.setImageResource(R.drawable.check_empty)
//            }
//
//            if (item.chek3 == true) {
//                box3.setImageResource(R.drawable.check_not_empty)
//            } else {
//                box3.setImageResource(R.drawable.check_empty)
//            }
//
//            if (item.chek4 == true) {
//                box4.setImageResource(R.drawable.check_not_empty)
//            } else {
//                box4.setImageResource(R.drawable.check_empty)
//            }
//
//            if (item.chek5 == true) {
//                box5.setImageResource(R.drawable.check_not_empty)
//            } else {
//                box5.setImageResource(R.drawable.check_empty)
//            }

        }

    }


    class SimpleNotesViewHolder(var holder: View) : RecyclerView.ViewHolder(holder) {
        fun bind(item: Notes) {
            var title = holder.findViewById<TextView>(R.id.TitleOfNote)
            var description = holder.findViewById<TextView>(R.id.TextOfNote)
            var time = holder.findViewById<TextView>(R.id.TimeOfNote)

            var Oval = holder.findViewById<View>(R.id.Oval)

            title.text = item.TitleCheck
            description.text = item.notesText
            time.text = item.notesDate
            Oval.setBackgroundResource(item.backgroundColor)


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View
        if (viewType == ITEM_SIMPLE) {
            view = LayoutInflater.from(context).inflate(R.layout.item_notes, parent, false)
            return SimpleNotesViewHolder(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_check, parent, false)
            return ChekNotesViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (noteList[position].notesType == 1) {
            var holder = holder as SimpleNotesViewHolder
            holder.bind(noteList[position])
            val data = noteList[position]

            holder.itemView.setOnClickListener {

                val action = HomeFragmentDirections.actionHomeFragmentToEditsNoteFragment(data)
                Navigation.findNavController(it).navigate(action)


            }
        } else {
            var holder = holder as ChekNotesViewHolder
            holder.bind(noteList[position])
            val data = noteList[position]

            holder.itemView.setOnClickListener {

                val action = HomeFragmentDirections.actionHomeFragmentToIscheckEdit(data)
                Navigation.findNavController(it).navigate(action)


            }
        }


    }


    override fun getItemViewType(position: Int): Int {
        if (noteList[position].notesType == 1) {
            return 1  /////////////////////////обычный нот
        } else {
            return 2 ///////////////////с галочкой
        }
    }


    override fun getItemCount() = noteList.size


}

//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//        var layoutInflater = LayoutInflater.from(parent.context)
//        lateinit var view : View
//
//        if (viewType == 1){
//
//            view = layoutInflater.inflate(R.layout.item_notes,parent,false)
//            return notesViewHolder(view)
//        }
//        else{
//
//            view = layoutInflater.inflate(R.layout.item_check,parent,false)
//            return notesViewHolder2(view)
//
//        }
//
//
//
//
//    }
//
//
//
//    fun filtering(newFilteredList: ArrayList<Notes>) {
//        noteList = newFilteredList
//        notifyDataSetChanged()
//    }
//
//     inner class notesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//         fun bindItemsOne(item : Notes ){
//
//             var title: TextView = itemView.findViewById(R.id.TitleOfNote)
//             var text: TextView = itemView.findViewById(R.id.TextOfNote)
//             var date: TextView = itemView.findViewById(R.id.TimeOfNote)
//             var dot: ImageView = itemView.findViewById(R.id.Oval)
//
//             title.text = item.notesTitle
//             text.text = item.notesText
//             date.text = item.notesDate
//             dot.setImageResource(item.backgroundColor)
//
//         }
//
//     }
//
//
//    inner class notesViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//        fun bindItemsTwo(item : Notes ){
//
//            var checkText1: TextView = itemView.findViewById(R.id.check_text1)
//            var checkText2: TextView = itemView.findViewById(R.id.check_text2)
//            var dot1: ImageView = itemView.findViewById(R.id.Oval)
//            var date: TextView = itemView.findViewById(R.id.TimeOfNote)
//
//            checkText1.text = item.chekText_1
//            checkText2.text = item.chekText_2
//            date.text = item.notesDate
//            dot1.setImageResource(item.backgroundColor)
//
//        }
//
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if(noteList[position].notesType == 1){
//            var holder : NoteAdapter.notesViewHolder = holder as notesViewHolder
//            return holder.bindItemsOne(noteList[position])
//        }else{
//            var holder : NoteAdapter.notesViewHolder2 = holder as notesViewHolder2
//            return holder.bindItemsTwo(noteList[position])
//        }
//
//    }
//
//    override fun getItemCount() = noteList.size


//    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
//        val data = noteList[position]
//        holder.binding.TextOfNote.text = data.notesText
//        holder.binding.TitleOfNote.text = data.notesTitle
//        holder.binding.TimeOfNote.text = "Last modified -  ${data.notesDate }"
//        holder.binding.Oval.setBackgroundResource(data.backgroundColor)
//        holder.binding.root.setOnClickListener {
//
//
//            val action = HomeFragmentDirections.actionHomeFragmentToEditsNoteFragment(data)
//            Navigation.findNavController(it).navigate(action)
//
//
//        }
//
//    }

//
//    override fun onBindViewHolder2(holder: notesViewHolder2, position: Int) {
//        val data = noteList[position]
//        holder.binding.checkText1.text = data.chekText_1
//        holder.binding.checkText2.text = data.notesTitle
//        holder.binding.TimeOfNote.text = "Last modified -  ${data.notesDate }"
//        holder.binding.Oval.setBackgroundResource(data.backgroundColor)
////        holder.binding.root.setOnClickListener {
////
////            val action = HomeFragmentDirections.actionHomeFragmentToIscheckEdit(data)
////            Navigation.findNavController(it).navigate(action)
////
////
////
////        }
//
//    }


//
//    override fun getItemCount() = noteList.size
//
//
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//}