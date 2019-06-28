import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalDateTime

//class Gigasecond (input: LocalDateTime){
//
//    constructor(input: LocalDate): this(input.atStartOfDay())
//
//    val date = input.plusSeconds(1_000_000_000L)
//}
//
//
//class Gigasecond(aDate: LocalDateTime) {
//
//    constructor(aDate: LocalDate) : this(aDate.atStartOfDay())
//
//    val date: LocalDateTime = aDate.plusSeconds(1e9.toLong())
//}
//
//
//class Gigasecond {
//
//    val date: LocalDateTime
//
//    constructor(initial: LocalDate): this(initial.atStartOfDay())
//
//    constructor(initial: LocalDateTime) {
//        date = initial.plusSeconds(1000000000)
//    }
//}


//class Gigasecond (val localDateTime: LocalDateTime) {
//  constructor (localDate: LocalDate) : this(localDate.atStartOfDay())
//  val date: LocalDateTime = localDateTime.plusSeconds(1_000_000_000)
//}

//class Gigasecond(val localDateTime: LocalDateTime) {
//  val date: LocalDateTime = localDateTime.plusSeconds(1_000_000_000)
//  constructor( localDate: LocalDate): this(localDate.atStartOfDay())
//}
//

//
///**
// * Stores date/time 1 gigasecond from the original date given in constructor
// * @param origin original date and time
// * @property date (read-only) stored date and time
// */
//class Gigasecond(origin: LocalDateTime) {
//    val date = origin.plusSeconds(1_000_000_000) /** blabla */
//
//    /** Alternate constructor
//     * @param origin original date, time is assumed as being 00:00:00
//     */
////    constructor(origin: LocalDate) : this(LocalDateTime.of(origin, LocalTime.of(0, 0, 0)))
//    constructor(origin: LocalDate): this(origin.atStartOfDay())
//}



//const val GIGA = 1_000_000_000L;
//class Gigasecond(initialDateTime : LocalDateTime){
//    constructor(initialDate: LocalDate) : this(initialDate.atStartOfDay())
//    val date: LocalDateTime = initialDateTime.plusSeconds(GIGA)
//
//}


//const val GIGA_SECOND=1_000_000_000L
//class Gigasecond(val birth: LocalDateTime){
//    val date = birth.plusSeconds(GIGA_SECOND)
//    constructor(localDate: LocalDate): this(localDate.atStartOfDay())
//}


//
//class Gigasecond(birthTime: LocalDateTime) {
//    val date: LocalDateTime = birthTime.plusSeconds(1E9.toLong())
//    constructor(birthTime: LocalDate) : this(birthTime.atStartOfDay())
//}



//
//class Gigasecond(birthDateTime: LocalDateTime) {
//    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())
//    val date: LocalDateTime = birthDateTime.plusSeconds(1e9.toLong())
//}



//class Gigasecond(dateTime: LocalDateTime){
//    constructor(date:LocalDate):this(date.atStartOfDay())
//    var date = dateTime
//    get() = field.plusSeconds(1_000_000_000L)
//}



//class Gigasecond (birthDate: LocalDateTime) {
//
//    var date: LocalDateTime = birthDate.plusSeconds(1_000_000_000)
//
//    constructor(birthDate: LocalDate): this(LocalDateTime.of(birthDate, LocalTime.MIDNIGHT))
//}


//class Gigasecond(from: LocalDateTime) {
//    val date: LocalDateTime = from.plusSeconds(1e9.toLong())
//    constructor(from: LocalDate) : this(LocalDateTime.of(from, LocalTime.MIN))
//}
//


//private const val GIGASECOND = 1000000000L
//class Gigasecond(of: LocalDateTime) {
//    constructor(of: LocalDate) : this(of.atStartOfDay())
//
//    val date: LocalDateTime = of.plusSeconds(GIGASECOND)
//}



//const val ONE_BILLION : Long = 1_000_000_000
//
//class Gigasecond(val startTime : LocalDateTime){
//    constructor(startDate : LocalDate) : this(startDate.atStartOfDay())
//    val date : LocalDateTime = startTime.plusSeconds(ONE_BILLION)
//}




//class Gigasecond(initDateTime: LocalDateTime) {
//    constructor(initDate: LocalDate) : this(initDate.atStartOfDay())
//
//    val date: LocalDateTime = initDateTime.plusSeconds(1e9.toLong())
//}



//
//class Gigasecond(date_: LocalDateTime) {
//    constructor(date_: LocalDate) : this(date_.atStartOfDay())
//
//    val date = date_.plusSeconds(1e9.toLong())
//}


//class Gigasecond(birthDateTime: LocalDateTime) {
//    val date: LocalDateTime = birthDateTime.plusSeconds(1_000_000_000)
//
//    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())
//}


private const val GIGA_SECOND=1_000_000_000L

class Gigasecond(val birthTime: LocalDateTime) {
    val date = birthTime.plusSeconds(GIGA_SECOND)
    constructor(localTime: LocalDate): this(localTime.atStartOfDay())
}



