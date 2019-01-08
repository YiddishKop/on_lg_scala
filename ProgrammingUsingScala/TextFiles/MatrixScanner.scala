import java.util.Scanner
import java.io.File

/*
3 3
1 0 0
0 1 0
0 0 1
 */
val sc = new Scanner(new File("matrix2.txt"))
val rows = sc.nextInt
val cols = sc.nextInt
// Scanner.nextLine is BAD for non-regular shape of data
// sc.nextLine
// val line = sc.nextLine
val matrix = Array.fill(rows, cols)(sc.nextDouble)
sc.close

matrix.foreach(r => println(r.mkString(" ")))

// val Array(rows, cols) = lines.split(" ").map(_.toDouble)