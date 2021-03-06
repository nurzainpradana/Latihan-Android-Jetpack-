package com.zainpradana.belajarkotlin.jetpack.academy.reader.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.belajarkotlin.jetpack.academy.R
import com.zainpradana.belajarkotlin.jetpack.academy.data.ModuleEntity
import com.zainpradana.belajarkotlin.jetpack.academy.databinding.FragmentModuleListBinding
import com.zainpradana.belajarkotlin.jetpack.academy.reader.CourseReaderActivity
import com.zainpradana.belajarkotlin.jetpack.academy.reader.CourseReaderCallback
import com.zainpradana.belajarkotlin.jetpack.academy.reader.viewmodel.CourseReaderViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.utils.DataDummy

class ModuleListFragment : Fragment(), MyAdapterClickListener {

    private lateinit var viewModel: CourseReaderViewModel

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    private lateinit var fragmentModuleListBinding: FragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false)
        return fragmentModuleListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ModuleListAdapter(this)

        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory()) [CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)
//        populateRecyclerView(DataDummy.generateDummyModules("a14"))
        populateRecyclerView(viewModel.getModules())
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with(fragmentModuleListBinding) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }
}