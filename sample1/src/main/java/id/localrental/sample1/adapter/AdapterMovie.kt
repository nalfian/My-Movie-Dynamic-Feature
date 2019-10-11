package id.localrental.sample1.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import id.localrental.sample1.R
import id.localrental.sample1.model.Movie
import id.localrental.sample1.ui.activity.DetailActivity

private class AdapterMovie(private val context: Context, private val movieList: List<Movie>) :
    RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvName.text = movieList[position].title
        holder.tvDesc.text = movieList[position].overview
        holder.tvDate.text = movieList[position].releaseDate
        Glide.with(context)
            .load("http://image.tmdb.org/t/p/w185" + movieList[position].posterPath)
            .into(holder.ivMovie)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("movie", movieList[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val ivMovie: ImageView = itemView.findViewById(R.id.ivMovie)

    }

}