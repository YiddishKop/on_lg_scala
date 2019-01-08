/*
1. from dataset get the number of min tempreture < 60
2. get the minimum of min tempreture
*/

// read dataset into an array by recursive
// just fill array with lines of dataset
def readDataToArray(index:Int, lines:Array[String]) {
    if(index < numlines){
        val line = readLine
        lines(index) = line
        readDataToArray(index+1, lines)
    }
}

val numlines = readInt
val lines = new Array[String](numlines)
readDataToArray(0, lines)

// pulling out information you need
val parts = lines.map(line => {
    val part = line.split(",")
    part(9).diff("\"\"").toDouble
})

println("lines in dataset: " + lines.length)
println("number of days min tempreture > 70: " + parts.count(_>70))
println("maximum tempreture of min tempreture: " + parts.max)