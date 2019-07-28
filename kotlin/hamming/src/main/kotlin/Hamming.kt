//package Hamming
//fun compute(strandA: String, strandB: String): Int {
//    require (strandA.length == strandB.length) { "left and right strands must be of equal length." }
//    return strandA.zip(strandB).count{ it.first != it.second }
//}

//package Hamming
////notes: modifier: public, private and internal work here
//internal fun compute(left: String, right: String): Int {
//    require (left.length == right.length) { "left and right strands must be of equal length." }
//    return left.zip(right).count{ it.first != it.second }
//}


//object Hamming {
//    fun compute(left: String, right: String): Int {
//        require (left.length == right.length) { "left and right strands must be of equal length." }
//        return left.zip(right).filter{ it.first != it.second }.count()
//    }
//}


//class Hamming {
////    companion object {
////        fun compute(left: String, right: String): Int {
////            require (left.length == right.length) {"left and right strands must be of equal length."}
////            return left.zip(right).count({ it.first != it.second })
////        }
////    }
////}

//package Hamming
//fun compute(left: String, right: String) : Int {
//    require( left.length == right.length) { "left and right strands must be of equal length." }
//    return left.zip(right).count{ it.first != it.second }
////    return left.zip(right).count({ (first, second) -> first != second })
////    return left.zip(right).count{(a, b) -> a != b }
//}
//

//class Hamming {
//    companion object {
//        fun compute(left:String, right:String):Int {
//            require(left.length == right.length) {"left and right strands must be of equal length."}
////            return left.zip(right){ a, b -> a != b }.count{ it }
//            return left.zip(right).count{ (a, b) -> a != b }
//        }
//    }
//}


//package Hamming
//fun compute(left:String, right:String):Int {
//    require(left.length == right.length) {"left and right strands must be of equal length."}
//    return left.zip(right).count{ it.first != it.second }
//}


//class Hamming{
//    companion object{
//        fun compute(left:String, right:String):Int {
//            require(left.length == right.length) {"left and right strands must be of equal length."}
//            var counter = 0
//
//            for ( i in 0 until left.length) {
//                if (left[i] != right[i]) counter++
//            }
//            return counter
//
//        }
//    }
//}

//
//class Hamming{
//    companion object{
//        fun compute(left:String, right:String):Int {
//            require(left.length == right.length) {"left and right strands must be of equal length."}
//
//            return if (left.length === 0) 0
////            else left.mapIndexed { i, v -> if (v !== right[i]) 1 else 0}.reduce{ acc, i -> acc + i}
//            else left.mapIndexed { i, v -> if (v !== right[i]) 1 else 0}.sum()
//
//        }
//    }
//}

//object Hamming {
//    fun compute(s: String, s1: String): Int {
//        if (s.length != s1.length) throw IllegalArgumentException("left and right strands must be of equal length.")
//
//        return if (s.length === 0) 0
//        else s.mapIndexed { i, c -> if (c !== s1[i]) 1 else 0 }
//                .reduce { acc, i -> acc + i }
//    }
//}


object Hamming{
    fun compute(left:String, right:String):Int {
        require(left.length == right.length) {"left and right strands must be of equal length."}
        return left.zip(right).count{ it.first != it.second }
    }
}











