import xml._

val gradeXML = XML.loadFile("grades.xml")
println(gradeXML.getClass) // class scala.xml.Elem

println(gradeXML)

// 2 basic operators used for searching for things inside of XML
// \
// \\
// in standard XML Library --- XPath, searching for things inside of XML
// /
// //
// but in scala '/' is divide; '//' is comment symbol

val students = gradeXML \ "student"
println(students.getClass) // class scala.xml.NodeSeq$$anon$1

println(students.length)
println(students(1))

// search an embedded tag
val colle = students.map(e => e \ "name")
println(colle.length)
colle.foreach(a => println(a.getClass)) // every is class scala.xml.NodeSeq$$anon$1
println(colle.getClass) // class scala.collection.immutable.$colon$colon

// search an attr in all node
val attrs = students.map(e => e \ "@name")
println(attrs.getClass) // class scala.collection.immutable.$colon$colon
println(attrs.mkString(", "))

// '\\' can sometime speed things up dramatcially
// '\' only find things 1 layer down
// gradeXML \ "quize" can NOT find anything
// where is good to use "\\"
// "\\" goes into multiple levels searching for stuff.
// it recursively descends into your .xml file

println(gradeXML \\ "quiz")