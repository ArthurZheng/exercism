private const val EARTH_ORBIT_SECONDS = 31_557_600L

class SpaceAge(val seconds:Long){

    fun toFixedTwoPlaces(num:Double) = Math.round(num * 100.00) / 100.00

    fun onEarth() = toFixedTwoPlaces(seconds / (EARTH_ORBIT_SECONDS * 1.0))

    fun onMercury() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS* 0.2408467))

    fun onVenus() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 0.61519726))

    fun onMars() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 1.8808158))

    fun onJupiter() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 11.862615))

    fun onSaturn() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 29.447498))

    fun onUranus() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 84.016846))

    fun onNeptune() = toFixedTwoPlaces( seconds / (EARTH_ORBIT_SECONDS * 164.79132))

}