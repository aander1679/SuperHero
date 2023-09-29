package com.codeanderDev.superherocompose

data class HeroResponse(val heroes:List<Hero>)
data class Hero (
    val id:String,
    val name: String,
    val biography : Biography,
    val image:HeroImage
)

data class Biography(val fullName:String)
data class HeroImage(val url:String)