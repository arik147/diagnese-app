package com.diagnese.app.core.data.network.disease

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: DiseaseItem,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)


