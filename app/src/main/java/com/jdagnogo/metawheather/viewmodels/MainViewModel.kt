package com.jdagnogo.metawheather.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdagnogo.metawheather.R
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.model.CityUiModel
import com.jdagnogo.metawheather.repository.WeatherRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(var repository: WeatherRepository) : ViewModel() {
    @VisibleForTesting
    var cityDetails: Job? = null
    var currentCityWoeId: String? = null
    var currentDate: Date? = null

    private val _cities = MutableLiveData<List<City>?>()
    val cities: LiveData<List<City>?>
        get() = _cities

    /**
     * Show a loading spinner if true
     */
    private val _spinner = MutableLiveData<Boolean>(false)
    val spinner: LiveData<Boolean>
        get() = _spinner

    /**
     * Request a snackbar to display a message.
     * This is used to notify that we dont have internet
     */
    @VisibleForTesting
    val _snackbar = MutableLiveData<Int?>()
    val snackbar: LiveData<Int?>
        get() = _snackbar

    /**
     * We want to display the snackbar only once.
     * So after that the value is displayed, we should reset the value
     */
    fun onSnackbarShown() {
        _snackbar.value = null
    }

    fun getCities() {
        viewModelScope.launch {
            repository.getCities().collectLatest {
                _cities.postValue(it)
            }
        }

    }

    fun isValid() = when {
        currentCityWoeId.isNullOrEmpty() -> {
            _snackbar.postValue(R.string.select_city)
            false
        }
        else -> {
            true
        }
    }

    fun updateCitySelected(city: City): List<CityUiModel> {
        currentCityWoeId = city.woeId
        return cities.value?.map {
            CityUiModel(it, it.id == city.id)
        } ?: listOf()
    }

    fun setDate(time: Long) {
        Calendar.getInstance().apply {
            timeInMillis = time
            currentDate = this.time
        }
    }
}