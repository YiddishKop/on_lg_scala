/*
you can call this method, by a special form of function literal: _<operator>_ e.g. _+_
readAndFn(3, _+_) 
 */
def readAndFn(n:Int, fn:(Int,Int) => Int):Int = {
    println("input grade: ")
    val grade = readInt
    if(n>1) {
        fn(grade, readAndFn(n-1, fn))
    } else { 
        grade
    }

}
def readAndSum_(n:Int):Int = {
    readAndFn(n,(grade:Int,sum_grade:Int) => grade + sum_grade)
}
def readAndProduct_(n:Int):Int = {
    readAndFn(n,(grade:Int,product_grade:Int) => grade * product_grade)
}
def readAndSum(n:Int):Int = {
    println("input grade: ")
    val grade = readInt
    if(n>1) {
        grade + readAndSum(n-1) 
    } else {
        grade
    }
}

def readAndProduct(n:Int):Int = {
    println("input grade: ")
    val grade = readInt
    if(n>1) {               
    /* 
    we ONLY change '+' with '*' from readAndSum()
    we should always avoid COPYING and PASTING, because
    more code, more bug.
    */
        grade * readAndProduct(n-1) 
    } else {
        grade
    }
}

println("how many grades do you have?")
val numGrades = readInt
val sumGrades = readAndSum_(numGrades)
println(s"The average is ${sumGrades.toDouble/numGrades}")
val productGrades = readAndProduct_(numGrades)
println(s"The average is ${math.pow(productGrades, 1.0/numGrades)}")


