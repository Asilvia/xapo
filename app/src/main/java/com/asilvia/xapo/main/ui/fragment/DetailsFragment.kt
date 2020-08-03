package com.asilvia.xapo.main.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.asilvia.xapo.R
import com.asilvia.xapo.main.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.details_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.dispatch(arguments)
        return inflater.inflate(R.layout.details_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderLayout()
    }

    private fun renderLayout() {
        owner?.text = viewModel.getOwner()
        name?.text = viewModel.getName()
        description?.text = viewModel.getDescription()
        stars?.text = viewModel.getStars()
        forks?.text = viewModel.getForks()
        homepage?.text = viewModel.getHomePage()

    }

}
