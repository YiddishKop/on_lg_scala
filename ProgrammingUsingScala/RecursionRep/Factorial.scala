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
try {
    val n = readInt
    println(s"factorial of ${n} is: " + factorial(n))
} catch {
    case ex:NumberFormatException => println("I said a number!")
}

println("input a non-negative integer, by match: ")
try {
    val m = readInt
    println(s"factorial of ${m} is: " + factorialM(m))
} catch {
    case ex:NumberFormatException => println("I said a number!")
}