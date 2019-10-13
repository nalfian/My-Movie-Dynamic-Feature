package id.localrental.sample1.presenter

import android.content.Context
import id.localrental.sample1.db.MovieDatabase
import id.localrental.sample1.model.Movie
import id.localrental.sample1.model.ResponseMovie
import id.localrental.sample1.util.Notify
import id.localrental.sample1.util.UtilsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingPresenter(private val upcomingView: UpcomingView, context: Context) {

    private val api = UtilsApi.movieServices
    private val api2 = UtilsApi.apiService2
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