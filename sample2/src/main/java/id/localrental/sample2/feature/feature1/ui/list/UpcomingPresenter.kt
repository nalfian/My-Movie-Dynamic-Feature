package id.localrental.sample2.feature.feature1.ui.list

import android.content.Context
import id.localrental.sample2.db.MovieDatabase
import id.localrental.sample2.feature.feature1.model.Movie
import id.localrental.sample2.feature.feature1.network.ResponseMovie
import id.localrental.sample2.util.Notify
import id.localrental.sample2.util.UtilsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingPresenter(private val upcomingView: UpcomingView, context: Context) {

    private val api = UtilsApi.movieServices
    private val db = MovieDatabase.invoke(context)

    fun getMovies() {
        api.getMovieUpcoming().enqueue(object : Callback<ResponseMovie> {
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                upcomingView.onFailureConnection()
            }

            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                if (response.isSuccessful) {
                    upsertLocalData(response.body()?.results)
                    getMoviesFromLocal()
                } else {
                    response.errorBody()?.charStream()?.let { reader ->
                        Notify.getMessageError(reader)?.let { upcomingView.onFailure(it) }
                    }
                }
            }

        })
    }

    private fun getMoviesFromLocal() {
        upcomingView.onSucces(db.movieDao().getMovie())
    }

    private fun upsertLocalData(results: List<Movie>?) {
        results?.let { db.movieDao().upsert(it) }
    }
}