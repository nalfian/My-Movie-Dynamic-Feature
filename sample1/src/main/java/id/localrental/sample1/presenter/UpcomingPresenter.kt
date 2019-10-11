package id.localrental.sample1.presenter

import android.content.Context
import androidx.lifecycle.LiveData
import id.localrental.sample1.db.MovieDatabase
import id.localrental.sample1.model.Movie
import id.localrental.sample1.model.ResponseMovie
import id.localrental.sample1.util.Notify
import id.localrental.sample1.util.UtilsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingPresenter(private val upcomingView: UpcomingView, context: Context) {

    private val api = UtilsApi.apiService
    private val db = MovieDatabase.invoke(context)

    fun syncMovies() {
        api.getMovieUpcoming().enqueue(object : Callback<ResponseMovie> {
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                upcomingView.onFailureConnection()
            }

            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                if (response.isSuccessful) {
                    response.body()?.results?.let { db.movieDao().upsert(it) }
                } else {
                    response.errorBody()?.charStream()?.let { reader ->
                        Notify.getMessageError(reader)?.let {
                            upcomingView.onFailure(
                                it
                            )
                        }
                    }
                }
            }

        })
    }

    suspend fun getMovies(): LiveData<out List<Movie>> {
        return withContext(Dispatchers.IO) {
            return@withContext db.movieDao().getMovie()
        }
    }
}