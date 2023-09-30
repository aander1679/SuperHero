package com.codeanderDev.superherocompose.repository

import com.codeanderDev.superherocompose.data.model.Hero
import com.codeanderDev.superherocompose.data.model.HeroResponse
import com.codeanderDev.superherocompose.data.remote.ApiClient
import com.codeanderDev.superherocompose.data.remote.HeroService
import com.codeanderDev.superherocompose.utils.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(private val heroService: HeroService = ApiClient.getHeroService()) {

    fun searchByName(name:String, callback:(Result<List<Hero>>)-> Unit) {
        val searchByName = heroService.searchByName(textQuery = name)
        searchByName.enqueue(object : Callback<HeroResponse> {
            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
               if(response.isSuccessful){
                   try {
                       callback(Result.Sucess(response.body()!!.heroes))
                   }catch (e:Exception){
                       callback(Result.Sucess(listOf<Hero>()))

                   }
               }
            }

            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                callback(Result.Error(t.localizedMessage ))
            }
        })

    }
}