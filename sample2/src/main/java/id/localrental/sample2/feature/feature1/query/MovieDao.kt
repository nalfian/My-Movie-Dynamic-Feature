package id.localrental.sample2.feature.feature1.query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.localrental.sample2.feature.feature1.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(movies: List<Movie>)

    @Query("select * from movie")
    fun getMovie(): List<Movie>

}