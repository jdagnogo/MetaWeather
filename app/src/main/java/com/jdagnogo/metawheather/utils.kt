package com.jdagnogo.metawheather

import android.content.ContentValues
import com.jdagnogo.metawheather.model.City

fun getKnownCities(): List<City> {
    val london = City("123rgehkj", "44418", "London")
    val gothenburg = City("123rrgrhkj", "44418", "Gothenburg")
    val stockholm = City("1rgegrhkj", "44418", "Stockholm")
    val mountainiew = City("123rrgyjtykrhkj", "44418", "Mountain View")
    val newYork = City("123rrcxgrhkj", "44418", "New York")
    val berlin = City("123rrgrpoihkj", "44418", "Berlin")
    return listOf(london, gothenburg, stockholm, mountainiew, newYork, berlin)
}

fun City.toContentValues(): ContentValues? {
    ContentValues().apply {
        put("id", this@toContentValues.id)
        put("name", this@toContentValues.name)
        return this
    }
}