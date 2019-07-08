//class Triangle(x: Double, y: Double, z: Double) {
//    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
//
//    init {
//        require(x > 0.0 || y > 0.0 || z > 0.0)
//        require(x + y >= z && x + z >= y && y + z >= x)
//    }
//
//    val isEquilateral = x == y && y == z
//    val isIsosceles = x == y || y == z || x == z
//    val isScalene = !isEquilateral && !isIsosceles
//}



//class Triangle(x: Double, y: Double, z: Double) {
//	constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())
//
//	init{
//		require(x > 0.0 || y > 0.0 || z > 0.0)
//		require( x + y >= z && x + z >= y && y + z >= x)
//	}
//
//	val isEquilateral = x == y && y == z
//	val isIsosceles = x == y || y == z || x == z
//	val isScalene = !isIsosceles
//
//}


//class Triangle(x: Double, y: Double, z: Double){
//	constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())
//
//	enum class Tri {ISOSCELES, SCALENE, EQUILATERAL}
//
//	val triType = listOf(x, y, z).sorted().let{ (a, b, c) ->
//		when {
//			a + b <= c || a == 0.0 -> throw IllegalArgumentException("DEGENERATE")
//			a == b && b == c -> Tri.EQUILATERAL
//			a == b || b == c -> Tri.ISOSCELES
//			else -> Tri.SCALENE
//		}
//
//	}
//
//	val isIsosceles = triType == Tri.ISOSCELES || triType ==  Tri.EQUILATERAL
//	val isScalene = triType == Tri.SCALENE
//	val isEquilateral = triType == Tri.EQUILATERAL
//}



//class Triangle(x: Double, y: Double, z: Double) {
//    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
//
//    init {
//        require(x > 0 && y > 0 && z > 0)
//        require(x + y >= z && y + z >= x && z + x >= y)
//    }
//
//    private val sides = Triple(x, y, z)
//
//    val isEquilateral = sides.allEqual()
//    val isIsosceles = sides.anyEqual()
//    val isScalene = !sides.anyEqual()
//}
//
//private fun <T> Triple<T, T, T>.allEqual() = first == second && second == third && third == first
//private fun <T> Triple<T, T, T>.anyEqual() = first == second || second == third || third == first





//
//class Triangle(val a: Double, val b: Double, val c: Double) {
//    constructor(a: Number, b: Number, c: Number) : this(a.toDouble(), b.toDouble(), c.toDouble())
//
//    init {
//        require(hasNonZeroSides())
//        require(sidesAreValid())
//        require(isNotDegenerate())
//    }
//
//    private fun hasNonZeroSides() = (a > 0 && b > 0 && c > 0)
//    private fun sidesAreValid() = (a + b >= c) && (b + c >= a) && (a + c >= b)
//    private fun isNotDegenerate() = (a + b != c) && (a + c != b) && (b + c != a)
//
//    val isEquilateral = (a == b) && (b == c)
//    val isIsosceles = (a == b) || (b == c) || (a == c)
//    val isScalene = (a != b) && (b != c)
//}
//
//
//
//
//class Triangle(
//        private val a: Double,
//        private val b: Double,
//        private val c: Double
//) {
//    constructor(a: Int, b: Int, c: Int)
//            : this(a.toDouble(), b.toDouble(), c.toDouble())
//
//    init {
//        require(a > 0) { "a must be > 0" }
//        require(b > 0) { "b must be > 0" }
//        require(c > 0) { "c must be > 0" }
//        require(a + b > c && a + c > b && b + c > a) { "triangle must be triangular" }
//    }
//
//    val isEquilateral: Boolean
//        get() = a == b && b == c
//    val isIsosceles: Boolean
//        get() = (a == b) || (b == c) || (a == c)
//    val isScalene: Boolean
//        get() = (a != b) && (b != c) && (c != a)
//}
//
//
//
//

//class Triangle(s1: Number, s2: Number, s3: Number) {
//    val isEquilateral : Boolean
//    val isIsosceles : Boolean
//    val isScalene : Boolean
//
//    init {
//        val sortedList = listOf(s1, s2, s3).map{ it.toFloat()}.sorted()
//        require(sortedList.none { it <= 0F }) {"sides must have size > 0"}
//        require(sortedList.last() <= sortedList.slice(0..1).sum()) {"violates triangle inequality"}
//        val sizes = listOf(s1, s2, s3).filter { it != 0 }.distinct().count()
//        when (sizes) {
//            1 -> {isEquilateral = true; isIsosceles = true; isScalene = false}
//            2 -> {isEquilateral = false; isIsosceles = true; isScalene = false}
//            3 -> {isEquilateral = false; isIsosceles = false; isScalene = true}
//            else -> throw IllegalArgumentException()
//        }
//    }
//}



//class Triangle(private val a: Number, private val b: Number, private val c: Number){
//	val isEquilateral: Boolean
//	val isIsosceles: Boolean
//	val isScalene: Boolean
//
//	init {
//		val sortedList = listOf(a, b, c).map{ it.toFloat()}.sorted()
//		require(sortedList.none { it <=0F }) {"Sides must have size > 0."}
//		require(sortedList.last() <= sortedList.slice(0..1).sum()) { "Violates triangle equality."}
//
//		val sizes = sortedList.filter{ it != 0F }.distinct().count()
//
//		when(sizes) {
//			1 -> { isEquilateral = true; isIsosceles = true; isScalene = false }
//			2 -> { isEquilateral = false; isIsosceles = true; isScalene = false }
//			3 -> { isEquilateral = false; isIsosceles = false; isScalene = true }
//			else -> throw IllegalArgumentException()
//		}
//	}
//}



//class Triangle(i: Double, i1: Double, i2: Double) {
//    constructor(i: Int, i1: Int, i2: Int) : this(i.toDouble(), i1.toDouble(), i2.toDouble())
//    init {
//        val invalidSizeCheck = listOf(i + i1 >= i2, i1 + i2 >= i, i2 + i >= i1).count{ !it } != 0
//        if(i == 0.0 || i1 == 0.0 || i2 == 0.0 || invalidSizeCheck) throw IllegalArgumentException()
//    }
//
//    private val equalities = listOf(i == i1, i1 == i2, i == i2)
//    val isEquilateral: Boolean = equalities.count { it == true } >= 2
//    val isIsosceles: Boolean = equalities.count { it == true } >= 1
//    val isScalene: Boolean =  equalities.count { it == true } == 0
//}
//
//
//
//class Triangle(x: Double, y: Double, z: Double) {
//    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
//
//    init {
//        require(listOf(x, y, z).all { it > 0.0 }, {"All edges must be greater than 0.0"})
//        require(x + y >= z && y + z >= x && z + x >= y, {"Triangle inequality"})
//    }
//
//    val isEquilateral = (x == y && y == z)
//    val isIsosceles: Boolean = (x == y || y == z || z == x)
//    val isScalene: Boolean = (x != y && y != z && z != x)
//}
//
//
//
//class Triangle(val base: Double, val side: Double, val hypotenuse: Double) {
//
//    val isEquilateral = (base == side) && (side == hypotenuse)
//    val isIsosceles = (base == side) || (side == hypotenuse) || (base == hypotenuse)
//    val isScalene = (base != side) && (side != hypotenuse) && (base != hypotenuse)
//
//    init {
//        if (base <= 0 || side <= 0 || hypotenuse <= 0) {
//            throw IllegalArgumentException("Triangles must have positive edge lengths")
//        } else if (base + side < hypotenuse
//                || base + hypotenuse < side
//                || side + hypotenuse < base) {
//            throw IllegalArgumentException("Invalid measurements")
//        }
//    }
//
//    constructor(base: Number, side: Number, hypotenuse: Number):
//            this(base.toDouble(), side.toDouble(), hypotenuse.toDouble())
//
//}
//
//
//
//
//class Triangle(val a: Double, val b: Double, val c: Double) {
//    init {
//        require(
//            a > 0
//            && b > 0
//            && c > 0
//            && a + b >= c
//            && a + c >= b
//            && b + c >= a)
//    }
//
//    constructor (a: Int, b: Int, c: Int):
//        this(a.toDouble(), b.toDouble(), c.toDouble())
//
//    val isEquilateral = a == b && a == c
//    val isIsosceles = a == b || b == c || a == c
//    val isScalene = !isIsosceles
//}
//
//
//
//
//class Triangle(vararg val arr: Double) {
//    constructor(vararg arr: Int):this(*(arr.map { it.toDouble() }.toDoubleArray()))
//
//    private val sides:List<Double>
//        get() {
//            val temp = arr.sorted()
//            if (temp.any { it <= 0 } || (temp[2] >= temp[0] + temp[1]) || temp.size > 3)
//                throw IllegalArgumentException()
//            return temp
//        }
//
//    val isEquilateral = sides.toSet().size == 1
//
//    val isIsosceles = sides.toSet().size <=2
//
//    val isScalene = sides.toSet().size == 3
//
//
//}




class Triangle(x: Double, y: Double, z: Double) {
    constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())

    init{
        require(x > 0.0 || y > 0.0 || z > 0.0)
        require( x + y >= z && x + z >= y && y + z >= x)
    }

    val isEquilateral = x == y && y == z
    val isIsosceles = x == y || y == z || x == z
    val isScalene = !isIsosceles
}

Jun Zheng 9:19 AM
class Triangle(val x: Double, val y: Double, val z: Double) {

  constructor(x: Int, y: Int, z: Int) :
      this(x.toDouble(), y.toDouble(), z.toDouble())

  enum class Tri { ISOSCELES, SCALENE, EQUILATERAL }

  val triType = listOf(x,y,z).sorted().let { (a,b,c) ->
    when {
      a + b <= c || a == 0.0 -> throw IllegalArgumentException("DEGENERATE")
      a == b && b == c       -> Tri.EQUILATERAL
      a == b || b == c       -> Tri.ISOSCELES
      else                   -> Tri.SCALENE
    }
  }

  val isIsosceles = triType == Tri.ISOSCELES || triType == Tri.EQUILATERAL
  val isScalene = triType == Tri.SCALENE
  val isEquilateral = triType == Tri.EQUILATERAL
}
Jun Zheng 9:58 AM


Jun Zheng 10:03 AM
class Triangle(val x: Double, val y: Double, val z: Double) {
    constructor(x: Int, y: Int, z: Int): this(x.toDouble(), y.toDouble(), z.toDouble())

    init {
        require( x > 0 && y > 0 && z >0)
        require(x + y >= z && x + z >= y && y + z  >= x)
    }

    private val sides = Triple(x, y, z)

    val isEquilateral = sides.allEqual()
    val isIsosceles = sides.anyEqual()
    val isScalene = !sides.anyEqual()
}

private fun <T> Triple<T, T, T>.allEqual() = first == second && second == third && third == first
private fun <T> Triple<T, T, T>.anyEqual() = first == second || first == third || second == third



Jun Zheng 10:14 AM
class Triangle(private val a: Number, private val b: Number, private val c: Number){
    val isEquilateral: Boolean
    val isIsosceles: Boolean
    val isScalene: Boolean

    init {
        val sortedList = listOf(a, b, c).map{ it.toFloat()}.sorted()
        require(sortedList.none { it <=0F }) {"Sides must have size > 0."}
        require(sortedList.last() <= sortedList.slice(0..1).sum()) { "Violates triangle equality."}

        val sizes = sortedList.filter{ it != 0F }.distinct().count()

        when(sizes) {
            1 -> { isEquilateral = true; isIsosceles = true; isScalene = false }
            2 -> { isEquilateral = false; isIsosceles = true; isScalene = false }
            3 -> { isEquilateral = false; isIsosceles = false; isScalene = true }
            else -> throw IllegalArgumentException()
        }
    }
}









