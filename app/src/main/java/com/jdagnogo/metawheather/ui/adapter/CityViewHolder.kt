package com.jdagnogo.metawheather.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jdagnogo.metawheather.R
import com.jdagnogo.metawheather.databinding.ListCitiesBinding
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.model.CityUiModel


class CityViewHolder(private val binding: ListCitiesBinding, var listener: CityListener) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            parent: ViewGroup, listener: CityListener
        ): CityViewHolder {
            val binding =
                ListCitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CityViewHolder(binding, listener)
        }
    }

    fun bind(cityUiModel: CityUiModel) {
        with(binding) {
            cityContainer.setOnClickListener {
                listener.onClick(cityUiModel.city)
            }
            cityName.text = cityUiModel.city.name
            cityName.setBackgroundColor(ContextCompat.getColor(root.context, R.color.colorAccent).takeIf {
                cityUiModel.isSelected
                    }?:ContextCompat.getColor(root.context, R.color.white))
        }
    }
}