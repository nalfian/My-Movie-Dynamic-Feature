package id.localrental.sample1.util

import id.localrental.sample1.BuildConfig
import id.localrental.sample1.network.MovieServices
import id.localrental.sample1.network.RetrofitClient

object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
