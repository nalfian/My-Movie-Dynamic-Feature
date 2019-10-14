package id.localrental.sample2.feature.feature1.ui.detail

import android.os.Bundle

import com.bumptech.glide.Glide
import id.localrental.sample2.R
import id.localrental.sample2.base.ScopedActivity
import id.localrental.sample2.feature.feature1.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : ScopedActivity() {

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getDataIntent()
        setupTitleToolbar()
        setupView()
    }

    private fun getDataIntent() {
        movie = intent.getParcelableExtra("data")
    }

    private fun setupTitleToolbar() {
        supportActionBar?.title = movie?.title
    }

    private fun setupView() {
        tvName.text = movie?.title
        tvDesc.text = movie?.overview
        tvDate.text = movie?.releaseDate
        Glide.with(this)
            .load("http://image.tmdb.org/t/p/w500" + movie?.posterPath)
            .into(ivMovie)
    }
}
