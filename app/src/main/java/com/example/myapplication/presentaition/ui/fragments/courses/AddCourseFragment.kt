package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.presentaition.ui.screens.AddCourseScreen
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddCourseFragment : Fragment() {
    private val addCourseViewModel: AddCourseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AddCourseScreen(
                    addCourseViewModel = addCourseViewModel,
                    onNextClick = {
                        lifecycleScope.launch {
                            replaceFragment("com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment")
                        }
                    }
                )
            }
        }
    }

    private suspend fun replaceFragment(fragmentName: String) {
        try {
            val fragment = requireActivity().supportFragmentManager.fragmentFactory
                .instantiate(requireActivity().classLoader, fragmentName)

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_id, fragment)
                .addToBackStack(null)
                .commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        fun newInstance() = AddCourseFragment()
    }
}