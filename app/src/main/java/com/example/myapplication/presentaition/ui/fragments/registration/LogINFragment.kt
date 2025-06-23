package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.presentaition.ui.screens.LoginScreen
import com.example.myapplication.presentaition.viewmodels.userviewmodel.CheckUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LogINFragment : Fragment() {
    private val viewModel: CheckUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen(
                    checkUserViewModel = viewModel,
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
        fun newInstance() = LogINFragment()
    }
}