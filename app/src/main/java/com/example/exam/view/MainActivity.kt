package com.example.exam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.exam.R
import com.example.exam.model.StateFragments
import com.example.exam.viewmodel.PostViewModel


//Это основной файл логики для активити, которое будет определять поведение приложения
class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()

    private lateinit var addFragment: AddFragment
    private lateinit var viewFragment: ViewFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment = AddFragment.newInstance()
        viewFragment = ViewFragment.newInstance()
        postViewModel.currentFragment.observe(this) {
            when(it){
                StateFragments.View -> postViewModel.goToView(supportFragmentManager, viewFragment)
                StateFragments.Add -> postViewModel.goToAdd(supportFragmentManager, addFragment)
            }
        }
    }
}
