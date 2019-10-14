package id.localrental.sample1.model

import com.google.gson.annotations.SerializedName

data class ResponseMovie(

    @field:SerializedName("dates")
	val dates: Dates? = null,

    @field:SerializedName("page")
	val page: Int? = null,

    @field:SerializedName("total_pages")
	val totalPages: Int? = null,

    @field:SerializedName("results")
	val results: List<Movie>? = null,

    @field:SerializedName("total_results")
	val totalResults: Int? = null
)