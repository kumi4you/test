package com.kumar.test.data.model

import java.io.Serializable

data class ShowResponse(
    val score: Double,
    val show: Show
) : Serializable

data class Show(
    val id: Int,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val status: String,
    val runtime: Int,
    val summary: String
) : Serializable

