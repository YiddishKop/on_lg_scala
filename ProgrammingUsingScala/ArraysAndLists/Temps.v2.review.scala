def readDataToArray(index:Int, arr:Array[String]) {
    if(index < arr.length) {
        val line = readLine
        arr(index) = line
        readDataToArray(index+1, arr)
    }
}

val numlines = readInt
val lines = new Array[String](numlines)
readDataToArray(0, lines)

println(s"numlines,read from file: $numlines. array length: ${lines.length}")

// pulling out (year, month, day, avg-tmps, high-temps, low-temps) as tuple, and print avg of high and low, comparing to avg-temps
// when given the year mothn day.
def extractData(line:String):(Int,Int,Int,Double,Double,Double) = {
    val arrOfLine:Array[String] = line.split(",")
    val (year,month,day,avgtmp,hightmp,lowtmp) =(arrOfLine(3).diff("\"\"").split("-")(0).toInt,
                                                 arrOfLine(3).diff("\"\"").split("-")(1).toInt,
                                                 arrOfLine(3).diff("\"\"").split("-")(2).toInt,
                                                 if (arrOfLine(7).length == 0) 0 else arrOfLine(7).diff("\"\"").toDouble,
                                                 arrOfLine(8).diff("\"\"").toDouble,
                                                 arrOfLine(9).diff("\"\"").toDouble)
    (year,month,day,avgtmp,hightmp,lowtmp)
}
// given the precise date by user input
val date = readLine.split("-")

// find whether there is a data in extracted dataset, result as Option
val opSearchResult = lines.map(extractData).find(a => a._1 == date(0).toInt 
                                                   && a._2 == date(1).toInt 
                                                   && a._3 == date(2).toInt)

opSearchResult match {
    case Some((_,_,_,av,high,low)) => 
        println(s"avg-temps is: $av;\navg of high and low tmps is: ${(high+low)/2}")
    case None =>
        println("what you want does not exist")
}