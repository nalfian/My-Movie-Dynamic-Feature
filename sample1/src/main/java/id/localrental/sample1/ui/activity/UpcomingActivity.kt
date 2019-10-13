package id.localrental.sample1.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.localrental.sample1.R
import id.localrental.sample1.model.Movie
import id.localrental.sample1.presenter.UpcomingPresenter
import id.localrental.sample1.presenter.UpcomingView
import id.localrental.sample1.util.Notify
import id.localrental.sample1.adapter.AdapterMovie
import id.localrental.sample1.base.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class UpcomingActivity : AppCompatActivity(), UpcomingView {

    override fun onSucces(movies: List<Movie>) {
        this.movies.addAll(movies)
        rvMoview.adapter?.notifyDataSetChanged()
    }

    override fun onFailure(message: String) {
       Notify.showOnFailure(rootView, message)
    }

    override fun onFailureConnection() {
        Notify.showOnFailureConnection(rootView, this)
    }


    private var movies: MutableList<Movie> = ArrayList()
    private var presenter: UpcomingPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        initPresenter()
        getMovies()
    }

    private fun getMovies() {
        presenter?.getMovies()
    }

    private fun initRv() {
        val listener = object : ItemClickListener {
            override fun onClick(position: Int) {
                goToDetail(position)
            }
        }

        rvMoview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            isNestedScrollingEnabled = false
            adapter = AdapterMovie(context, movies, listener)
        }
    }

    private fun goToDetail(position: Int) {
        startActivity(
            Intent(this, DetailActivity::class.java)
            .putExtra("data", movies[position])
        )
    }

    private fun initPresenter() {
        presenter = UpcomingPresenter(this, this)
    }
}
