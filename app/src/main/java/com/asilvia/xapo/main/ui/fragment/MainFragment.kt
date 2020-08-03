package com.asilvia.xapo.main.ui.fragment

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.asilvia.xapo.R
import com.asilvia.xapo.main.ui.adapter.RepositoriesAdapter
import com.asilvia.xapo.main.viewmodel.MainViewModel
import com.asilvia.xapo.shared.model.Item
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.repositories_list
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), RepositoriesAdapter.Companion.OnRepositoryClick {



    val viewModel: MainViewModel by viewModel()

    private lateinit var viewAdapter: RepositoriesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeObservers()
    }

    private fun initializeObservers() {
        viewModel.getRepositoryObservable().observe(this, Observer {
            viewAdapter.setList(it.items)
        })
        viewModel.getSnackBarObservable().observe(this, Observer{
           //Error handling
        })

    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainView = inflater.inflate(R.layout.main_fragment, container, false)
        viewModel.init()
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewAdapter = RepositoriesAdapter(this)
        createList()
    }

    private fun createList() {
        viewManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        repositories_list?.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    override fun onClick(item: Item) {
        val countryFactBundle = Bundle().apply {
            putParcelable("item",item)
        }
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_detailsFragment, countryFactBundle)
    }

}
