package id.localrental.sample2.feature.feature1.network

import id.localrental.sample2.BuildConfig
import retrofit2.Call
import retrofit2.http.GET

interface MovieServices {

    @GET(BuildConfig.UPCOMING)
    fun getMovieUpcoming(): Call<ResponseMovie>

}