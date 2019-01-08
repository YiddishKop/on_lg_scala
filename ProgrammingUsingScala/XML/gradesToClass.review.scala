/*
[Problem] read gradesToClass.xml to case class and then save case class to grades2.review.xml file
 */
import xml._

/*
[Part-1] read gradesToClass.xml to case Object
 */
case class Grade(value:Int, comment:Option[String])
case class Student(name:String, grades:List[Grade], tests:List[Grade], assignments:List[Grade])

// keep in mind that case class is an advanced tuple, what tuple do is to group many types of infor
def toGrade(node:Node):Grade = {
    val vl = (node \ "@value").text.toInt
    val cm_tmp = (node \ "comment").text
    // Wrap your result with <if None else Some> will give you an Option
    val cm = if (cm_tmp.isEmpty) None else Some(cm_tmp)
    Grade(vl, cm)
}

def toStudent(node:Node):Student = {
    val nm = (node \ "@name").text
    // attention here, what you want is object, so keep this in mind
    val gd = (node \ "quiz").map(toGrade).toList
    val ts = (node \ "test").map(toGrade).toList
    val as = (node \ "assignment").map(toGrade).toList
    Student(nm, gd, ts, as)
}

val grades = XML.loadFile("gradesToClass.xml")
val students = grades \ "student"
val objCollect = students.map(toStudent)

// keep in mind that you can print a case class object directly, this is one reason why prefer case class than class
objCollect.foreach(println)

/*
[Part-2] save collection case Object 'students' to grades2.review.xml 
*/

// when you want to get content from Some of an Option, the ONLY way is by pattern match
def grdToXML(grd:Grade, t:String):Node = {
    def extractCmt = grd.comment match {
        case Some(c) =>
            <comment>{c}</comment>
        case None =>
            ""
    }
    t match {
        case "quiz" =>
            <quiz value={grd.value.toString}>{extractCmt}</quiz>
        case "test" =>
            <test value={grd.value.toString}>{extractCmt}</test>
        case "assignment" =>
            <assignment value={grd.value.toString}>{extractCmt}</assignment>
    }
}
def stuToXML(stu:Student):Node =
    <student name={stu.name}>
        <name>{stu.name}</name>
        {stu.grades.map(a => grdToXML(a, "quiz"))}
        {stu.tests.map(a => grdToXML(a, "test"))}
        {stu.assignments.map(a => grdToXML(a, "assignment"))}
    </student>

XML.save("grades2.review.xml", <grades>{objCollect.map(stuToXML)}</grades>)