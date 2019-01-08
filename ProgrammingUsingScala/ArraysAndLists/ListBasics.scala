// fill a List of a given length with user input
def readList(len:Int):List[Int] = {
    if (len>0) readInt() :: readList(len-1)
    else Nil
}

// Read List of unknow length, similar to while
def readListUntilQuit():List[Int] = {
    val word = readLine
    if (word != "end") word.toInt :: readListUntilQuit()
    else Nil
}

// Sum List
def sumList(lst:List[Int]):Int = {
    if(lst.isEmpty) 0
    else lst.head + sumList(lst.tail)
}

// List of tuples with names and ages
def readNamesAndAges():List[(String,Int)] = {
    println("input name: ")
    val name = readLine
    if(name == "end") Nil
    else {
        println("input age: ")
        val age = readInt
        (name,age) :: readNamesAndAges()
    }
}

// Find youngest person
def findYoungest(lst:List[(String,Int)]):(String,Int) = {
    if (lst.tail.isEmpty) lst.head
    else {
        val youngest = findYoungest(lst.tail)
        if(lst.head._2 < youngest._2) lst.head else youngest
    } 
}

// Code using functions

// val lst = readList(5)
// println(lst)
// println("sum : " + sumList(lst))

// val lst_uq = readListUntilQuit()
// println(lst_uq)
// println("sum : " + sumList(lst_uq))

// val lst_naa = readNamesAndAges()
// println(lst_naa)

val lst_tst = List(("yiddi",32), ("yuanxin",27), ("yuanming",29), ("yuanli",34))
val youngest = findYoungest(lst_tst)
println(youngest)