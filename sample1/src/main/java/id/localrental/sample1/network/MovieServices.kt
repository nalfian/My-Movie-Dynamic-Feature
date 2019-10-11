package id.localrental.sample1.network

import id.localrental.sample1.BuildConfig
import id.localrental.sample1.model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices{

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}