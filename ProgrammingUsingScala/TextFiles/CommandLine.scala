import scala.io.Source

def printFile(fileName:String) {
    println("\n\n" + "<<<<" + fileName + ">>>>")
    val src = Source.fromFile(fileName)
    // println(src.mkString)
    src.foreach(print)
    src.close
}

if(args.length<1) println("you need to specify file names.") 
else args.foreach(printFile)