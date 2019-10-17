package id.localrental.sample4.util

import id.localrental.sample4.BuildConfig
import id.localrental.sample4.data.network.service.MovieServices
import id.localrental.sample4.data.network.RetrofitClient

object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
