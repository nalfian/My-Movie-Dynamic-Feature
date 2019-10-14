package id.localrental.sample2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.localrental.sample2.feature.feature1.model.Movie
import id.localrental.sample2.feature.feature1.query.MovieDao

@Database(
    entities = [Movie::class],
    version = 1
)

abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java, "movie.db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}