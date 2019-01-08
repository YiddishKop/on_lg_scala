// read in temp data with fill
// val numlines = readInt
// val lines = Array.fill(numlines)(readLine)

// println(s"numlines = $numlines, length = ${lines.length}")


// then we can improve this by add some function to 2nd parameter which is pass-by-name
// pass by name 可以构建平台函数，可以接入不同的功能，这是 pass by name 的本质 --- copy code
def parseTemps(line:String):Array[Double] = {
    val parts = line.split(",")
    Array(parts(8).diff("\"\"").toDouble,parts(9).diff("\"\"").toDouble)
} 

val lines = Array.fill(readInt)(parseTemps(readLine))
lines.last.foreach(println)

