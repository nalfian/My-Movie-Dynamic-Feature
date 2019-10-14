package id.localrental.sample1.presenter

import id.localrental.sample1.model.Movie


interface UpcomingView {
    fun onSucces(movies: List<Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}