def countUp(highestValue:Int) {
    var i = 0
    while(i <= highestValue) {
        println(i)
        i += 1
    }
}

def buildList():Array[String] = {
    val numlines = readInt
    println(numlines)
    val lines = new Array[String](numlines)
    var i = 0
    while(i < numlines){
        lines(0) = readLine
        println(lines(0))
        i += 1
    }
    lines
}
buildList()
countUp(10)