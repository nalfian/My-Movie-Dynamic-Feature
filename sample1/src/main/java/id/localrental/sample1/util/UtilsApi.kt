package id.localrental.sample1.util

import id.localrental.sample1.BuildConfig
import id.localrental.sample1.network.MovieServices
import id.localrental.sample1.network.RetrofitClient

object UtilsApi {
    val apiService: MovieServices
        get() = RetrofitClient.getClient(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
