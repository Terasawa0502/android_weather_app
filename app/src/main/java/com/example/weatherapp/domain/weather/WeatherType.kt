package com.example.weatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.example.weatherapp.R

sealed class WeatherType (
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
        ) {

    // 雷雨
    object RainyThunder: WeatherType(
        weatherDesc = "雷雨",
        iconRes = R.drawable.ic_rainythunder
    )

    // 雨
    object Rainy: WeatherType(
        weatherDesc = "雨",
        iconRes = R.drawable.ic_rainy
    )

    // 曇り
    object Cloudy: WeatherType(
        weatherDesc = "曇り",
        iconRes = R.drawable.ic_cloudy
    )

    // 雪
    object Snowy: WeatherType(
        weatherDesc = "雪",
        iconRes = R.drawable.ic_snowy
    )

    object HeavySnow: WeatherType(
        weatherDesc = "大雪",
        iconRes = R.drawable.ic_heavysnow
    )

    object RainShower: WeatherType(
        weatherDesc = "霧雨",
        iconRes = R.drawable.ic_rainshower
    )

    object SnowyRain: WeatherType(
        weatherDesc = "雨と雪",
        iconRes = R.drawable.ic_snowyrain
    )

    // 晴れ
    object Sunny: WeatherType(
        weatherDesc = "晴れ",
        iconRes = R.drawable.ic_sunny
    )

    object SunnyCloudy: WeatherType(
        weatherDesc = "曇り",
        iconRes = R.drawable.ic_sunnycloudy
    )
    // 雷
    object Thunder: WeatherType(
        weatherDesc = "雷",
        iconRes = R.drawable.ic_thunder
    )

    object VeryCloudy: WeatherType(
        weatherDesc = "曇り",
        iconRes = R.drawable.ic_very_cloudy
    )

    object SunnyRainy: WeatherType(
        weatherDesc = "晴れのち曇り",
        iconRes = R.drawable.ic_sunnyrainy
    )

    // 強風
    object Windy: WeatherType(
        weatherDesc = "雰囲気",
        iconRes = R.drawable.ic_windy
    )


    companion object{
        fun fromWeatherId(id: Int): WeatherType{
            Regex(pattern = "^2.[0-9]{2}").matches(id.toString())
            val regexGroup2 = Regex(pattern = "^2.[0-9]{2}")
            val regexGroup3 = Regex(pattern = "^3.[0-9]{2}")
            val regexGroup5 = Regex(pattern = "^5.[0-9]{2}")
            val regexGroup6 = Regex(pattern = "^6.[0-9]{2}")
            val regexGroup7 = Regex(pattern = "^7.[0-9]{2}")
            val regexGroup8 = Regex(pattern = "^8.[0-9]{2}")
            return when {
                // グループ 2XX:雷雨
                regexGroup2.matches(id.toString()) -> typeGroup2(id)
                // グループ 3XX:霧雨
                regexGroup3.matches(id.toString()) -> typeGroup3(id)
                // グループ 5XX:雨
                regexGroup5.matches(id.toString()) -> typeGroup5(id)
                // グループ 6XX:雪
                regexGroup6.matches(id.toString()) -> typeGroup6(id)
                // グループ 7XX:雰囲気
                regexGroup7.matches(id.toString()) -> typeGroup7(id)
                // グループ 800:クリア
                // グループ 80X:雲
                regexGroup8.matches(id.toString()) -> typeGroup8(id)
                else -> Sunny
            }
        }

        private fun typeGroup2 (id: Int): WeatherType =
            when (id) {
                200,
                201,
                202,
                210,
                211,
                212,
                221,
                230,
                231,
                232 -> RainyThunder
                else -> RainyThunder
            }

        private fun typeGroup3 (id: Int): WeatherType =
            when (id) {
                300,
                301,
                302,
                310,
                311,
                312,
                313,
                314,
                321 -> RainShower
                else -> RainShower
            }

        private fun typeGroup5 (id: Int): WeatherType =
            when (id){
                500,
                501,
                502,
                503,
                504,
                511,
                520,
                521,
                522,
                531 -> Rainy
                else -> Rainy
            }

        private fun typeGroup6 (id: Int): WeatherType =
            when (id) {
                600,
                601 -> Snowy
                602 -> HeavySnow
                611,
                612,
                613,
                615,
                616 -> SnowyRain
                620,
                621 -> Snowy
                622 -> HeavySnow
                else ->Snowy
            }

        private fun typeGroup7 (id: Int): WeatherType =
            when (id) {
                701,
                711,
                721,
                731,
                741,
                751,
                761,
                762,
                771,
                781 -> Windy
                else -> Windy
            }

        private fun typeGroup8 (id: Int): WeatherType =
            when (id) {
                800 -> Sunny
                801,
                802 -> SunnyCloudy
                803 -> Cloudy
                804 -> VeryCloudy
                else -> VeryCloudy
            }
    }

}