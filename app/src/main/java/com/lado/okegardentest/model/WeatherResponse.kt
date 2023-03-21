package com.lado.okegardentest.model

data class WeatherResponse(
	val current: Current? = null,
)

data class Current(
	val temp_c: Any? = null,
	val temp_f: Any? = null,
)
