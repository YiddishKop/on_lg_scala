// read data from csv file by redirection, getting 
// 10 lines of Data excluding other information
// make a subtraction between every adjacent season.

// 1. excluding 6 line in front
for (i <- 1 to 6) println(readLine)

// 2. get 10 data lines and store in Array by fill
// everyline format: (title, Array(23.0, 234.23, 2342.121, ...))
def parseData(line:String):(String,Array[Double]) = {
    val parts = line.split(",").tail
    val title = parts(0).diff("\"\"").trim
    val data = for(i <- parts.tail) yield i.toDouble
    (title, data)
}
val arrData = Array.fill(10)(parseData(readLine))
arrData.foreach(a => println(a._1+a._2.mkString))

// 3. make subtraction between adjacent season income
// method 1: with nested for 
// val resultArr = for((title, data) <- arrData) yield {
//     // understand the for yield layer
//     val arrSub = for(i <- 0 until data.length -1 ) yield {
//         data(i+1) - data(i)
//     }
//     (title, arrSub.toArray)
// } 

// method 2: with for and zip
// val resultArr = for((title, data) <- arrData) yield {
//     val arrSub = data.zip(data.tail).map(a => a._2 - a._1)
//     (title, arrSub)
// }

// method 3: with for and tabulate
val resultArr = for((title, data) <- arrData) yield {
    val arrSub = Array.tabulate(data.length - 1)(i => data(i+1) - data(i))
    (title, arrSub)
}


resultArr.foreach(a => println(a._1 +" "+ a._2.mkString("   ")))




