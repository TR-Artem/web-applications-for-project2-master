package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCoursesBinding
import com.example.myapplication.presentaition.ui.adapters.ItemCourseAdapter
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.GetCourseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoursesFragment : Fragment() {
    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemCourseAdapter
    private val getCourseViewModel: GetCourseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ItemCourseAdapter(requireActivity())
        binding.courseRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.courseRecyclerView.adapter = adapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                getCourseViewModel.courses.collect { items ->
                    adapter.updateList(items)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = CoursesFragment()
    }
}