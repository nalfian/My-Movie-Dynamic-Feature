package id.localrental.sample3.util

import id.localrental.sample3.BuildConfig
import id.localrental.sample3.data.network.MovieServices
import id.localrental.sample3.data.network.RetrofitClient

object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
