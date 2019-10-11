package id.localrental.sample1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.localrental.sample1.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(movie: List<Movie>)

    @Query("select * from movie sort")
    fun getMovie(): LiveData<List<Movie>>


}