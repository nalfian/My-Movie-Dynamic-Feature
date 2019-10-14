package id.localrental.sample2.util

import id.localrental.sample2.BuildConfig
import id.localrental.sample2.feature.feature1.network.MovieServices
import id.localrental.sample2.network.RetrofitClient


object UtilsApi {
    val movieServices: MovieServices
        get() = RetrofitClient.invoke(BuildConfig.BASE_URL).create(MovieServices::class.java)
}
