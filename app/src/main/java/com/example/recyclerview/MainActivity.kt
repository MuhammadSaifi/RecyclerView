package com.example.recyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.childe_hobby.view.*
// import dependency see in dependency folder
class MainActivity : AppCompatActivity() {
    val hobby= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyle.layoutManager = LinearLayoutManager(this)
        recyle.adapter  = hobbyAdapter(hobby,this)
        load()
      // in line 21 hobby is our list name
        // for create the grid recycler view simply type
        // recycle.layoutManager =  GridLayoutManager(this)
        // instead of line 20
    }
    fun load(){
        hobby.add("Gardning")
        hobby.add("Coin Collecting")
        hobby.add("Movie")
        hobby.add("Sports")
        hobby.add("Teasing")
    }
    class hobbyAdapter(items:List<String>,ctx:Context): RecyclerView.Adapter<hobbyAdapter.ViewHolder>(){
        class ViewHolder(v:View) : RecyclerView.ViewHolder(v){
            val name = v.hobby_name
        }
        var list = items
        var context = ctx
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hobbyAdapter.ViewHolder {
                  return ViewHolder(LayoutInflater.from(context).inflate(R.layout.childe_hobby,parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: hobbyAdapter.ViewHolder, position: Int) {
           holder.name.text=list.get(position)
        }

    }

}
