package com.zainpradana.belajarkotlin.jetpack.academy.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.belajarkotlin.jetpack.academy.R
import com.zainpradana.belajarkotlin.jetpack.academy.academy.adapter.AcademyAdapter
import com.zainpradana.belajarkotlin.jetpack.academy.databinding.FragmentAcademyBinding
import com.zainpradana.belajarkotlin.jetpack.academy.utils.DataDummy

class AcademyFragment : Fragment() {

    private lateinit var fragmentAcademyBinding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val courses = DataDummy.generatedDummyCourses()
            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourses(courses)

            with(fragmentAcademyBinding.rvAcademy) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}