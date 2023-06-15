package com.diagnese.app.core.domain.data

data class Disease(
    val code : Int,
    val data : List<DiseaseData>,
    val message : String,
    val status : String
)

data class DiseaseData(
    val spesialis: String,
    val deskripsi: String,
    val prognosis: String
)