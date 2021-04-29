package com.jdagnogo.metawheather.ui

import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jdagnogo.metawheather.R
import com.jdagnogo.metawheather.databinding.FragmentHomeBinding
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.model.CityUiModel
import com.jdagnogo.metawheather.ui.adapter.CityAdapter
import com.jdagnogo.metawheather.ui.adapter.CityListener
import com.jdagnogo.metawheather.viewmodels.MainViewModel
import javax.inject.Inject

class HomeFragment : BaseFragment(), CityListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: CityAdapter
    private lateinit var binding: FragmentHomeBinding

    @VisibleForTesting
    lateinit var viewModel: MainViewModel
    override fun subscribeViewModel() {
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
                .get(MainViewModel::class.java).apply {
                    getCities()
                }
    }

    override fun observeValues() {
        viewModel.cities.observe(this, citiesObserver)
        viewModel.snackbar.observe(this, snackBarObserver)
    }

    private val citiesObserver = Observer<List<City>?> { cities ->
        adapter.submitList( cities?.map { CityUiModel(it) })
    }

    private val snackBarObserver = Observer<Int?> { text ->
        text?.let {
            Snackbar.make(binding.container, text, Snackbar.LENGTH_SHORT)
            .show()
            viewModel.onSnackbarShown()
        }
    }

    override fun setSupportInjection(): Fragment {
        return this
    }

    override fun initViewBiding(): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews() {
        adapter.listener = this
        with(binding) {
            citiesList.adapter = adapter
            validateButton.setOnClickListener {
                viewModel.setDate(binding.calendarView.date)
                if (viewModel.isValid()){
                    redirectToCityDetails()
                }
            }
        }
    }

    private fun redirectToCityDetails() {
        val fragment = childFragmentManager.findFragmentByTag(CityDetailsFragment.TAG)
                ?: CityDetailsFragment.newInstance()
        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment, CityDetailsFragment.TAG)
            addToBackStack(null)
            commit()
        }
    }


    override fun onClick(city: City) {
        adapter.submitList(viewModel.updateCitySelected(city))
    }
}