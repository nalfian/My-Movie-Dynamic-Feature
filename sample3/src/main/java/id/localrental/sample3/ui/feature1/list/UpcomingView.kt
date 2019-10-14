package id.localrental.sample3.ui.feature1.list

import id.localrental.sample3.data.db.entity.Movie


interface UpcomingView {
    fun onSucces(movies: List<Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}