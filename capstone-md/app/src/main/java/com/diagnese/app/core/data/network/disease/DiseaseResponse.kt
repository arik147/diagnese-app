package com.diagnese.app.core.data.network.disease

import com.google.gson.annotations.SerializedName

data class DiseaseResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DiseaseItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DiseaseItem(

	@field:SerializedName("spesialis")
	val spesialis: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("prognosis")
	val prognosis: String
)


