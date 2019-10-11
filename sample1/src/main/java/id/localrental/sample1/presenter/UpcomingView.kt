package id.localrental.sample1.presenter

import androidx.lifecycle.LiveData
import id.localrental.sample1.model.Movie

interface UpcomingView {
    fun onSucces(movies: LiveData <out Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}