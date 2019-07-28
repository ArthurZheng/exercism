class Year(year: Int){
//    val isLeap = year.rem(4) == 0 && (year.rem(100) !=0 || year.rem(400) == 0)
//    val isLeap = year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0)
    val isLeap = (year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0
}