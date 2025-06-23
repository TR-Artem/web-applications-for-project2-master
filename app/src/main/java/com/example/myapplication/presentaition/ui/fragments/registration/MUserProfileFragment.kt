package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserProfileBinding
import com.example.myapplication.presentaition.viewmodels.userviewmodel.GetUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MUserProfileFragment : Fragment() {
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!
    private val getUserViewModel: GetUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            getUserViewModel.user.collectLatest { user ->
                user?.let {
                    binding.profileAgeId.text = it.age.toString()
                    binding.profileNameId.text = it.username
                    binding.profileCurrentPhoneId.text = it.phoneNumber

                    Glide.with(requireContext())
                        .load(it.profilePhoto)
                        .placeholder(R.drawable.course)
                        .into(binding.profileImageId)
                }
            }
        }

        binding.profileButtonForCoursesId.setOnClickListener {
            lifecycleScope.launch {
                replaceFragment("com.example.myapplication.presentaition.ui.fragments.courses.CoursesFragment")
            }
        }

        binding.profileButtonForAddingCoursesId.setOnClickListener {
            lifecycleScope.launch {
                replaceFragment("com.example.myapplication.presentaition.ui.fragments.courses.AddCourseFragment")
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MUserProfileFragment()
    }
}