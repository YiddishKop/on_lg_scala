// case class Vector(x:Double, y:Double, z:Double)

// val v1 = Vector(1.0, 2.0, 3.0)

// println(v1.x)

// def magnitude(v:Vector):Double = math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z)

// println(magnitude(v1))

// println(magnitude(Vector(2.0, 3.0, 4.0)))


//2 methods to write content to file
/*
import java.io.{PrintWriter,File,BufferedWriter,FileWriter}

val pw = new PrintWriter("testPwWithPath.txt")
pw.println("hello world")
pw.close

val file = new File("testPWWithFile.txt")
val pw2 = new PrintWriter(file)
pw2.println("hello world")
pw2.close

val fw = new FileWriter("testFW")
val bw = new BufferedWriter(fw)
bw.write("hello world")
bw.close
*/

// 2 methods to read from file
/*
import scala.io.Source
import java.io.File
import java.util.Scanner

val file = new File("testFw") 
val source = Source.fromFile(file)
println(source.next)
val lines = source.getLines
println(lines.next)
source.close

val sc = new Scanner("testPWWithFile.txt")
println(sc.next)
sc.close
*/

// Source + map + toArray
// Scanner + Array.fill
// eg read modify every word to uppercase write
// import java.io.{PrintWriter, BufferedWriter, File, FileWriter}
// import java.util.Scanner
// import scala.io.Source

// val sc = Source.fromFile("testFW")
// val lines = sc.getLines
// val newArr = lines.map(line => {
//     val words = line.split(" ")
//     words.map(word => word.toUpperCase)}).toArray 
//     // words.map(word => {
//     //     if(word.head.isLetter) word.head.toUpper +: word.tail
//     //     else word})}).toArray
// sc.close
// newArr.foreach(a => a.foreach(println))

// val pw = new PrintWriter("newTestFW")
// newArr.foreach(a => a.foreach(pw.println))
// pw.close

// use argument list to print file content
import scala.io.Source

def printFile(file:String) {
    val source = Source.fromFile(file)
    val lines = source.getLines
    lines.foreach(println)
}

args.foreach(printFile)