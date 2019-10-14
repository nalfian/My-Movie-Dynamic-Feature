package id.localrental.sample2.feature.feature1.ui.list

import id.localrental.sample2.feature.feature1.model.Movie

interface UpcomingView {
    fun onSucces(movies: List<Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}