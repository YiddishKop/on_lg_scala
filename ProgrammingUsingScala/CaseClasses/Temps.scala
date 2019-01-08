import scala.io.Source

/*
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-01","0.02","0.0","0",,"92","70"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-02","0.01","0.0","0",,"90","74"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-03","0.00","0.0","0",,"91","74"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-04","0.00","0.0","0",,"90","69"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-05","0.00","0.0","0",,"90","70"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-06","0.00","0.0","0",,"91","70"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-07","0.03","0.0","0",,"90","71"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-08","0.23","0.0","0",,"86","72"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-09","0.00","0.0","0",,"92","74"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-10","0.00","0.0","0",,"92","74"
"USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","1946-09-11","0.00","0.0","0",,"93","69"
*/
case class TempData(dateOfMonth:Int, dayOfYear:Int, month:Int, year:Int, tAve:Double, tMax:Double, tMin:Double)
def parseTemps(line:String):TempData = {
    val parts = line.split(",").map(word => word.filter(_ != '"'))
    // parts.mkString(",  ")
    val date = parts(3).split("-")
    val dateOfMonth_ = date(2).toInt
    val month_ = date(1).toInt
    val year_ = date(0).toInt
    val dayOfYear_ = month_ * 30 + dateOfMonth_
    val tAve_ = parts(7).toDouble 
    val tMax_ = parts(8).toDouble
    val tMin_ = parts(9).toDouble
    TempData(dateOfMonth_, dayOfYear_, month_, year_, tAve_, tMax_, tMin_)
}

val source = Source.fromFile("1198704.csv")
val lines = source.getLines
val tempDatas = lines.filterNot(_.contains(",,")).map(parseTemps).toArray
source.close

// compute avg of avg/max/min tmp of all the data
println(s"Ave = ${tempDatas.map(_.tAve).sum/tempDatas.length}")
println(s"High = ${tempDatas.map(_.tMax).sum/tempDatas.length}")
println(s"Low = ${tempDatas.map(_.tMin).sum/tempDatas.length}")

// compute avg of avg of every month
for(month <- 1 to 12) {
    println(s"Ave of $month = ${tempDatas.filter(_.month == month).map(_.tAve).sum/tempDatas.filter(_.month == month).length}")
}

// compute number of max > 100
println(s"highs above 100: ${tempDatas.count(_.tMax > 100)} days")