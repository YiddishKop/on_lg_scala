// this program reads and dose a little analysis of income data

// skip lines those actually useless.
for(i <- 1 to 4) readLine

// read year and 10 lines after that
/*
"Line","","2015","2015","2015","2015","2016","2016","2016","2016","2017","2017","2017","2017"
"Line","","Q1","Q2","Q3","Q4","Q1","Q2","Q3","Q4","Q1","Q2","Q3","Q4"
"1","Personal income",15301.0,15516.1,15625.5,15769.2,15751.0,15910.1,16028.0,16025.7,16245.2,16339.6,16451.9,16630.8
"2","    Compensation of employees",9541.6,9655.9,9730.0,9905.5,9838.6,9979.6,10081.4,10014.9,10166.3,10243.0,10336.5,10432.8
"3","        Wages and salaries",7718.4,7813.7,7873.5,8030.0,7964.9,8090.2,8178.1,8107.8,8232.1,8295.2,8374.3,8456.7
"4","            Private industries",6459.8,6543.3,6593.9,6736.1,6669.7,6785.2,6863.4,6792.7,6901.6,6958.4,7029.2,7104.5
"5","            Government",1258.6,1270.4,1279.6,1293.9,1295.1,1305.0,1314.6,1315.2,1330.5,1336.8,1345.1,1352.2
"6","        Supplements to wages and salaries",1823.3,1842.2,1856.5,1875.5,1873.7,1889.4,1903.4,1907.1,1934.2,1947.9,1962.2,1976.0
"7","            Employer contributions for employee pension and insurance funds1",1261.7,1273.9,1284.1,1292.2,1298.6,1305.5,1313.3,1321.7,1332.7,1341.7,1350.4,1358.3
"8","            Employer contributions for government social insurance",561.6,568.3,572.4,583.3,575.1,583.9,590.1,585.4,601.6,606.1,611.8,617.7
"9","    Proprietors' income with inventory valuation and capital consumption adjustments",1312.8,1313.9,1323.2,1325.4,1327.6,1339.5,1346.1,1354.6,1380.2,1378.6,1381.9,1401.9
"10","        Farm",52.0,53.0,58.7,51.0,46.8,46.7,41.4,37.8,41.9,37.0,31.9,29.7
*/

val yearLing = readLine
val seasonLine = readLine
val dataLines = for(i <- 1 to 10) yield readLine

// conver dataLines to other format: get rid of 1st column
// other columns in current line, will be converted to a tuple of String(which is "Personal incom") 
// and Array(which is all numbers follow "Personal income")
def lineToTuple(line:String):(String, Array[Double]) = {
    val parts = line.split(",")
    val header = parts(1).filter(_ != '"').trim // trim the double quote symbol and the spaces in front of each title
    val data = parts.drop(2).map(_.toDouble)
    (header, data)
}

val incomeData = dataLines.map(lineToTuple)

// these 2 methods are both good, especially 1st one, who use mkString, is easy and convinient.
// incomeData.foreach(a => println(a._1+" "+a._2.mkString(",  ")))
// for((title, data) <- incomeData) {println(title); data.foreach(println)}

// Basic-Method : print out column-to-column difference, in different areas.
val diffs = for((h,data) <- incomeData) yield { // use for loop's pattern match to pull out head-title and followed-data 
    val diff = for(i <- 0 until data.length - 1) yield data(i+1) - data(i) // use for loop's collection to traverse data
    (h, diff)
}
// Improved-Method: print out column-to-column difference, in different areas.
// this method is [more functional-oriented] than up one, but this method is [less efficient] than up one
// because this method creat a new Array of tuple by zip instead of using index of original Array directly.
// a trade-off between [funtional style] and [effciency]
val diffs = for((h,data) <- incomeData) yield {
    val diff = for((y1,y2) <- data.zip(data.tail)) yield y2 - y1
    (h, diff)
}

println(diffs)
diffs.foreach(a => println(a._1+" "+a._2.mkString(",   ")))
println(diffs(0)._2.mkString(", "))



