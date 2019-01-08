import scala.io.Source

val matrixSource = Source.fromFile("matrix.txt")
val matrixLines = matrixSource.getLines
val matrix = matrixLines.map(line => line.split(", ").map(_.toDouble)).toArray
matrixSource.close // close file

matrix.foreach(r => println(r.mkString(" "))o

val scoreSource = Source.fromFile("boxscore.txt")
val scoreLines = scoreSource.getLines
val boxscore = scoreLines.map(line => line.split("\t")).toArray
scoreSource.close

boxscore.foreach(player => println(player.mkString(" - ")))
println(boxscore.filter(_(0).contains("Ginobili"))(0).mkSring(" "))
val cols = boxscore(0).length
val totalPoints = boxscore.map(_(cols-1)).map(_.toInt).sum
println(totalPoints)