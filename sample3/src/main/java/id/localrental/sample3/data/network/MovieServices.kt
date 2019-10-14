package id.localrental.sample3.data.network

import id.localrental.sample3.data.network.response.ResponseMovie
import id.localrental.sample3.BuildConfig
import retrofit2.Call
import retrofit2.http.GET

interface MovieServices {

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}