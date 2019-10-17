package id.localrental.sample4.data.network.service

import id.localrental.sample4.data.network.response.ResponseMovie
import id.localrental.sample4.BuildConfig
import retrofit2.Call
import retrofit2.http.GET

interface MovieServices {

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}