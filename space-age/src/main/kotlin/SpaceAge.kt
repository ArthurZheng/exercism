//
//class SpaceAge(val seconds:Long){
//    companion object {
//        private const val EARTH_ORBIT_SECONDS = 31_557_600L
//    }
//
//    fun toFixedTwoPlaces(num:Double) = Math.round(num * 100.00) / 100.00
//
//    fun onEarth() = toFixedTwoPlaces(seconds / (EARTH_ORBIT_SECONDS * 1.0))
//
//    fun onMercury() = translateSpaceYear(ratio = 0.2408467)
//
//    fun onVenus() = translateSpaceYear(ratio = 0.61519726)
//
//    fun onMars() = translateSpaceYear(ratio = 1.8808158)
//
//    fun onJupiter() = translateSpaceYear(ratio = 11.862615)
//
//    fun onSaturn() =  translateSpaceYear(ratio = 29.447498)
//
//    fun onUranus() = translateSpaceYear(ratio =  84.016846)
//
//    fun onNeptune() = translateSpaceYear(ratio = 164.79132)
//
//    private fun translateSpaceYear(ratio: Double) = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * ratio))
//
//}


//import SpaceAge.Planet.*
//import java.math.BigDecimal
//import java.math.RoundingMode
//
//private const val SECONDS_IN_EARTH_YEAR = 31_557_600L
//
//class SpaceAge(private val seconds: Long) {
//
//    private enum class Planet(val earthYearsPerYear: Double) {
//        EARTH(1.0),
//        MERCURY(0.2408467),
//        VENUS(0.61519726),
//        MARS(1.8808158),
//        JUPITER(11.862615),
//        SATURN(29.447498),
//        URANUS(84.016846),
//        NEPTUNE(164.79132)
//    }
//
//    private fun Long.toYearsOnPlanet(planet: SpaceAge.Planet): Double {
//        return BigDecimal(this / (planet.earthYearsPerYear * SECONDS_IN_EARTH_YEAR))
//                .setScale(2, RoundingMode.HALF_EVEN)
//                .toDouble()
//    }
//
//    fun onEarth() = seconds.toYearsOnPlanet(EARTH)
//    fun onMercury() = seconds.toYearsOnPlanet(MERCURY)
//    fun onVenus() = seconds.toYearsOnPlanet(VENUS)
//    fun onMars() = seconds.toYearsOnPlanet(MARS)
//    fun onJupiter() = seconds.toYearsOnPlanet(JUPITER)
//    fun onSaturn() = seconds.toYearsOnPlanet(SATURN)
//    fun onUranus() = seconds.toYearsOnPlanet(URANUS)
//    fun onNeptune() = seconds.toYearsOnPlanet(NEPTUNE)
//
//}



//import SpaceAge.Planet.*
//import java.math.BigDecimal
//import java.math.RoundingMode.HALF_UP
//
//class SpaceAge(private val seconds: Long){
//    companion object{
//       private const val EARTH_ORBIT_SECONDS = 31_557_600L
//    }
//
//    private enum class Planet(val ratio: Double){
//        EARTH(1.0),
//        MERCURY(0.2408467 ),
//        VENUS(0.61519726),
//        MARS(1.8808158),
//        JUPITER(11.862615),
//        SATURN(29.447498),
//        URANUS(84.016846),
//        NEPTUNE(164.79132)
//    }
//
//    private fun toYearsOnPlanet(planet: SpaceAge.Planet) =
//            BigDecimal(seconds / (planet.ratio * EARTH_ORBIT_SECONDS ))
//                    .setScale(2, HALF_UP)
//                    .toDouble()
//
//    fun onEarth() = toYearsOnPlanet(EARTH)
//    fun onMercury() = toYearsOnPlanet(MERCURY)
//    fun onVenus() = toYearsOnPlanet(VENUS)
//    fun onMars() = toYearsOnPlanet(MARS)
//    fun onJupiter() = toYearsOnPlanet(JUPITER)
//    fun onSaturn() = toYearsOnPlanet(SATURN)
//    fun onUranus() = toYearsOnPlanet(URANUS)
//    fun onNeptune() = toYearsOnPlanet(NEPTUNE)
//}
//


























