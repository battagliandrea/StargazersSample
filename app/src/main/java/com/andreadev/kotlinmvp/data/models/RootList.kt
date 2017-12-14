package com.andreadev.kotlinmvp.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by andrea on 14/09/2017.
 */
class RootList (
    @SerializedName("people") var people: String,
    @SerializedName("planets") var planets: String,
    @SerializedName("films") var films: String,
    @SerializedName("species") var species: String,
    @SerializedName("vehicles") var vehicles: String,
    @SerializedName("starships") var starships: String
)
{
    fun getList() : List<String> = arrayListOf(people, planets, films, species, vehicles, starships)
}
