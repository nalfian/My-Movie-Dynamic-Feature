package id.localrental.sample2.feature.feature1.model

import com.google.gson.annotations.SerializedName

data class Dates(

	@field:SerializedName("maximum")
	val maximum: String? = null,

	@field:SerializedName("minimum")
	val minimum: String? = null
)