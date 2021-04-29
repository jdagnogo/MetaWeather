package com.jdagnogo.metawheather.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.model.CityUiModel

/**
 * We are comparing with the id as it s the primary key
 */
class CityComparator : DiffUtil.ItemCallback<CityUiModel>() {
    override fun areItemsTheSame(oldItem: CityUiModel, newItem: CityUiModel): Boolean {
        return oldItem.city.woeId == newItem.city.woeId
    }

    override fun areContentsTheSame(oldItem: CityUiModel, newItem: CityUiModel): Boolean {
        return oldItem == newItem
    }
}