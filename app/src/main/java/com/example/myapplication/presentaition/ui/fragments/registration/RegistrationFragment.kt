package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()
    private val addUserViewModel: AddUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileBtnId.setOnClickListener {
            val name = binding.editUsernameId.text.toString()
            val password = binding.editPasswordId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.text.toString()
            val age = binding.editAgeId.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty()) {
                val user = User(
                    username = name,
                    password = password,
                    phoneNumber = phoneNumber,
                    profilePhoto = R.drawable.course,
                    age = age.toInt()
                )

                lifecycleScope.launch {
                    addUserViewModel.addUser(user)
                    replaceFragment("com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment", user)
                }
            }
        }
    }

    private suspend fun replaceFragment(fragmentName: String, user: User) {
        try {
            val fragment = requireActivity().supportFragmentManager.fragmentFactory
                .instantiate(requireActivity().classLoader, fragmentName)

            fragment.arguments = Bundle().apply {
                putString("ARG_USERNAME_STRING", user.username)
                putString("ARG_PHONE_NUMBER_STRING", user.phoneNumber)
                putString("ARG_AGE_STRING", user.age.toString())
                putInt("ARG_PROFILE_PHOTO", R.drawable.course)
            }

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
        fun newInstance() = RegistrationFragment()
    }
}