package id.localrental.sample1.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import id.localrental.sample1.R
import id.localrental.sample1.base.ScopedActivity
import id.localrental.sample1.model.Movie
import id.localrental.sample1.presenter.UpcomingPresenter
import id.localrental.sample1.presenter.UpcomingView
import id.localrental.sample1.util.lazyDeferred
import kotlinx.coroutines.launch

class UpcomingActivity : ScopedActivity(), UpcomingView {

    private lateinit var presenter: UpcomingPresenter

    override fun onSucces(movies: LiveData<out Movie>) {

    }

    override fun onFailure(message: String) {

    }

    override fun onFailureConnection() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = UpcomingPresenter(this, this)
        bindView()
        presenter.syncMovies()
    }

    private fun bindView() = launch {
        val weather by lazyDeferred {
            presenter.getMovies()
        }

        weather.await().observe(this@UpcomingActivity, Observer {
            Log.d("Coba", it.toString())
        })
    }
}
