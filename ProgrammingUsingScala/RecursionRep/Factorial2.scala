/* 
define a default value by try-catch to avoid
handling exception in so many functins who use
this value as augument 
*/
def readIntWithDefault(default:Int):Int = try{
    readInt
} catch {
    case ex:NumberFormatException => default
}

// a 'if' version of factorial
def factorial(n:BigInt):BigInt = {
    // !!! WRONG if use code commented out below
    // if(n == 0) 1
    // if(n>0) {
    //     n*factorial(n-1)
    // } else 1
    if(n>1) n*factorial(n-1) else 1
}

// a 'match' version of factorial
val ZERO = BigInt(0)
val ONE = BigInt(1)
def factorialM(m:BigInt):BigInt = m match {
    case ZERO => 1 // you can't just use BigInt(0) here, becase this place ONLY for pattern
                   // BigInt(0) is not a pattern
    case ONE => 1 
    case _ => m * factorialM(m-1)
}


println("input a non-negative integer, by if: ")
val n = readIntWithDefault(-1)
if(n>=0) {
    println(s"factorial of ${n} is: " + factorial(n))
} else {
    println("I said a number!")
}

println("input a non-negative integer, by match: ")
val m = readIntWithDefault(-1)
if(m>=0) {
    println(s"factorial of ${m} is: " + factorialM(m))
} else {
    println("I said a number!")
}