def printValue(n:Int) { // a procedure withou ":type =" remeber that?
    println(n)
    printValue(n)
}

def countDown(n:Int) {
    if (n>=0) {        // set base-case as condition of if statement 
        println(n)     // body, operation you want to do
        countDown(n-1) // call function-self with augument updated one step further
    }
}

println("what number do you want to count down?")
val n = readInIntt
countDown(n)