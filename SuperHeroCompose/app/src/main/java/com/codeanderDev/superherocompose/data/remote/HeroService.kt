package com.codeanderDev.superherocompose.data.remote

import com.codeanderDev.superherocompose.data.model.HeroResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  HeroService {
    @GET("{api_Token}/search/{textQuery}")
    fun searchByName(@Path("api_Token") apiToken:String = "10157703717092094",
                     @Path("textQuery") textQuery:String
    ): Call<HeroResponse>

}