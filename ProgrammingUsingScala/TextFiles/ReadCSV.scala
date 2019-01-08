import scala.io.Source

// 0xd = 13
def readCSVLine(src:Source):Array[String] = {
    var c = if(src.hasNext) src.next else ' '
    var ret = List[String]()
    var inQuotes = false
    var cur = ""
    while(src.hasNext && c!=13){
        if(c == ',' && !inQuotes) {
            ret ::= cur
            cur = ""
        } else if(c == '\"') {
            inQuotes = !inQuotes
        } else if(c == '\\') {
            cur += src.next
        } else {
            cur += c
        }
        c = src.next
        // , 
        // "
        // \
        // everything else
    }
    ret ::= cur
    ret.reverse.toArray
}

val source = Source.fromFile("NOD3x-RaceAgainstTheMachines.csv")
while(source.hasNext) {
    println(readCSVLine(source).mkString(", "))
}