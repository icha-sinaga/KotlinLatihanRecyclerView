package com.example.latihanrecylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    val list = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTours = findViewById(R.id.rvTours)
        rvTours.setHasFixedSize(true)

        list.addAll(listTour)
        showRecyclerView()
    }

    private val listTour: ArrayList<Tour>
            get() {
                val dataName = resources.getStringArray(R.array.data_name)
                val dataDescription = resources.getStringArray(R.array.data_description)
                val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

                val lists = ArrayList<Tour>()
                for (i in dataName.indices){
                    val tour = Tour(
                        dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1)
                    )
                    lists.add(tour)
                }
                return lists
            }

    fun showRecyclerView(){
        rvTours.layoutManager =LinearLayoutManager(this)
        val tourListAdapter = TourListAdapter(list)
        rvTours.adapter = tourListAdapter
    }
}