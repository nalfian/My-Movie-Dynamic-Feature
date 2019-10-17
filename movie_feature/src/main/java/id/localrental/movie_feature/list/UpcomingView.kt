package id.localrental.movie_feature.list

import id.localrental.sample4.data.db.entity.Movie


interface UpcomingView {
    fun onSucces(movies: List<Movie>)
    fun onFailure(message: String)
    fun onFailureConnection()
}