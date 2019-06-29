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



//import java.math.BigDecimal
//private const val EARTH_YEAR_SECONDS = 31557600.0
//
//private fun Double.round2() = this.toBigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
//
//class SpaceAge(private val seconds: Long) {
//
//    fun onEarth(): Double = (seconds / EARTH_YEAR_SECONDS).round2()
//    fun onMercury(): Double = convertTo(orbitalPeriodInEarthYears = 0.2408467)
//    fun onVenus(): Double = convertTo(orbitalPeriodInEarthYears = 0.61519726)
//    fun onMars(): Double = convertTo(orbitalPeriodInEarthYears = 1.8808158)
//    fun onJupiter(): Double = convertTo(orbitalPeriodInEarthYears = 11.862615)
//    fun onSaturn(): Double = convertTo(orbitalPeriodInEarthYears = 29.447498)
//    fun onUranus(): Double = convertTo(orbitalPeriodInEarthYears = 84.016846)
//    fun onNeptune(): Double = convertTo(orbitalPeriodInEarthYears = 164.79132)
//
//    private fun convertTo(orbitalPeriodInEarthYears: Double) = (seconds / EARTH_YEAR_SECONDS / orbitalPeriodInEarthYears).round2()
//}
//


//import java.math.BigDecimal
//
//private const val EARTH_YEAR_SECONDS = 31557600.0
//
//private fun Double.round2() = this.toBigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
//
//private enum class Planet(val ratio: Double) {
//    EARTH(1.0),
//    MERCURY(0.2408467 ),
//    VENUS(0.61519726),
//    MARS(1.8808158),
//    JUPITER(11.862615),
//    SATURN(29.447498),
//    URANUS(84.016846),
//    NEPTUNE(164.79132)
//}
//
//class SpaceAge(private val seconds: Long) {
//    private fun toPlanetYear(planet: Planet): Double{
//        return (seconds / planet.ratio / EARTH_YEAR_SECONDS).round2()
//    }
//
//    fun onEarth() = toPlanetYear(Planet.EARTH)
//    fun onMercury() = toPlanetYear(Planet.MERCURY)
//    fun onVenus() = toPlanetYear(Planet.VENUS)
//    fun onMars() = toPlanetYear(Planet.MARS)
//    fun onJupiter() = toPlanetYear(Planet.JUPITER)
//    fun onSaturn() = toPlanetYear(Planet.SATURN)
//    fun onUranus() = toPlanetYear(Planet.URANUS)
//    fun onNeptune() = toPlanetYear(Planet.NEPTUNE)
//}


//
//class SpaceAge(val seconds: Long) {
//    enum class Planet(val relPeriod: Double) {
//        Earth(1.0),
//        Mercury(0.2408467),
//        Venus(0.61519726),
//        Mars(1.8808158),
//        Jupiter(11.862615),
//        Saturn(29.447498),
//        Uranus(84.016846),
//        Neptune(164.79132);
//
//        fun age(seconds: Long) = (seconds / 31557600.0 / relPeriod)
//    }
//
//    fun onEarth() = Planet.Earth.age(seconds).twoDecimals()
//    fun onMercury() = Planet.Mercury.age(seconds).twoDecimals()
//    fun onVenus() = Planet.Venus.age(seconds).twoDecimals()
//    fun onMars() = Planet.Mars.age(seconds).twoDecimals()
//    fun onJupiter() = Planet.Jupiter.age(seconds).twoDecimals()
//    fun onSaturn() = Planet.Saturn.age(seconds).twoDecimals()
//    fun onUranus() = Planet.Uranus.age(seconds).twoDecimals()
//    fun onNeptune() = Planet.Neptune.age(seconds).twoDecimals()
//
//    fun Double.twoDecimals() = String.format("%.2f", this).toDouble()
//
//}
//
//

class SpaceAge (private val seconds: Long){

    companion object{
        private const val EARTH_YEAR_SECONDS = 31557600.0
    }

//    private fun Double.twoDecimals() = (Math.round( this * 100.00 ) / 100.00).toDouble()
//    private fun Double.toTwoDecimalPlaces() = Math.round(this * 100.0)/100.0
//    private fun Double.roundUp() = BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toDouble()
//    private  fun Double.twoDecimals() = String.format("%.2f", this).toDouble()
    private fun Double.twoDecimals() = "%.2f".format(this).toDouble()

    private enum class Planet(val ratio: Double) {
        Earth(1.0),
        Mercury(0.2408467),
        Venus(0.61519726),
        Mars(1.8808158),
        Jupiter(11.862615),
        Saturn(29.447498),
        Uranus(84.016846),
        Neptune(164.79132);

        fun age(seconds: Long) = (seconds / ratio / EARTH_YEAR_SECONDS).toDouble()
    }

    fun onEarth() = Planet.Earth.age(seconds = seconds).twoDecimals()
    fun onMercury() = Planet.Mercury.age(seconds = seconds).twoDecimals()
    fun onVenus() = Planet.Venus.age(seconds = seconds).twoDecimals()
    fun onMars() = Planet.Mars.age(seconds = seconds).twoDecimals()
    fun onJupiter() = Planet.Jupiter.age(seconds = seconds).twoDecimals()
    fun onSaturn() = Planet.Saturn.age(seconds = seconds).twoDecimals()
    fun onUranus() = Planet.Uranus.age(seconds = seconds).twoDecimals()
    fun onNeptune() = Planet.Neptune.age(seconds = seconds).twoDecimals()
}






















































































