package com.jdagnogo.metawheather.ui

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class CityDetailsFragment :BaseFragment(){
    override fun subscribeViewModel() {
        TODO("Not yet implemented")
    }

    override fun observeValues() {
        TODO("Not yet implemented")
    }

    override fun setSupportInjection(): Fragment {
        TODO("Not yet implemented")
    }

    override fun initViewBiding(): View {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }


    companion object {
        fun newInstance() = CityDetailsFragment().apply {
            arguments = bundleOf()
        }

        const val TAG = "CityDetailsFragment"
    }

}