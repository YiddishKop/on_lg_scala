import xml._

case class Grade(value:Int, comment:Option[String])
case class Student(name:String, quizzes:List[Grade], tests:List[Grade], assignments:List[Grade])

def toGrade(node:Node):Grade = {
    println(node.text)
    val value = (node \ "@value").text.toInt 
    val comments = (node \ "comment").map(_.text) 
    val comment = if(comments.isEmpty) None else Some(comments.head)
    Grade(value, comment)
}

def toStudent(node:Node):Student = {
    val name = (node \ "@name").text
    val quizzes = (node \ "quiz").map(toGrade).toList
    val tests = (node \ "test").map(toGrade).toList
    val assignments = (node \ "assignment").map(toGrade).toList
    Student(name, quizzes, tests, assignments)
}

def gradeToXML(g:Grade, t:String):Node = {
    def makeComments = g.comment match{
                case Some(c) => <comment>{c}</comment>
                case None => ""
        }
    t match {
        case "quiz" =>
            <quiz value={g.value.toString}>
                {makeComments}
            </quiz>
        case "test" =>
            <test value={g.value.toString}>
                {makeComments}
            </test>
        case "assignment" =>
            <assignment value={g.value.toString}>
                {makeComments}
            </assignment>
        }
}


def studentToXML(s:Student):Node = 
    <student name = {s.name}>A
        {s.quizzes.map(n => gradeToXML(n, "quiz"))}
        {s.tests.map(n => gradeToXML(n, "test"))}
        {s.assignments.map(n => gradeToXML(n, "assignment"))}
    </student>

val gradeXML = XML.loadFile("gradesToClass.xml")

val students = (gradeXML \ "student").map(toStudent)

println("-------------- begint here ------------")
println(students.getClass)
println(students(1))
students.foreach(println)

XML.save("grades2.xml", <grades>{students.map(studentToXML)}</grades> )
