class Triangle(private val sideA: Double, private val sideB: Double, private val sideC: Double) {

    init {
        require(sideA > 0F || sideB > 0F || sideC > 0F) {"All sides have to be of length >0."}
        require(sideA + sideB >= sideC && sideB + sideC >= sideA && sideA + sideC >= sideB){throw IllegalArgumentException()}
    }

    constructor(sideA: Int, sideB: Int, sideC: Int): this(sideA.toDouble(), sideB.toDouble(), sideC.toDouble())

    val isEquilateral = sideA == sideB && sideB == sideC
    val isIsosceles = sideA == sideB || sideA == sideC || sideB == sideC
    val isScalene = !isIsosceles
}