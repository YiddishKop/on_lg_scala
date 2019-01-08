import xml._

// read from grades.xml and get students name and their quize score
val elem = XML.loadFile("grades.xml")
val students = elem \ "student"
students.foreach(println)
println(students.map(_ \ "@name").mkString(", "))