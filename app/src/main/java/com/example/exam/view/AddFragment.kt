package com.example.exam.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.exam.model.StateFragments
import com.example.exam.R
import com.example.exam.model.database.Post

import com.example.exam.viewmodel.PostViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class AddFragment : Fragment(R.layout.fragment_add) {

    val viewModel: PostViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addPost)
            .setOnClickListener {
                viewModel.putPostToDb(
                    Post(
                        id = 0,
                        userId = 1,
                        title = view.findViewById<TextInputEditText>(R.id.titleText).text.toString(),
                        body = view.findViewById<TextInputEditText>(R.id.bodyText).text.toString()
                    ),
                    requireContext()
                )
                viewModel.changeFragment(StateFragments.View)
            }
        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            viewModel.changeFragment(StateFragments.View)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddFragment()
    }
}
