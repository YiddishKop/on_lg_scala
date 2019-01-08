// Inefficient way
def fibo(n:Long):Long = {
    if(n>=2L) fibo(n-1) + fibo(n-2)
    else 1L
}

// define a NUMBER to fib(n)'n
val testNum = 500

// for(i <- 1 to 20) println(fibo(i))
val fibo1 = System.nanoTime
// println(fibo(5))
// println(fibo(15))
// println(fibo(testNum))
// println("fibo use time: "+(System.nanoTime - fibo1)*1E-9)

// ---------------------------Efficient for
def fibLoop(n:Long):Long= {
    if(n<2L) 1L else {
        var (a,b) = (1L, 1L)
        var c = a + b
        for(i <- 3L to n) {
            a = b
            b = c
            c = a + b
        }
        c
    }
}

val fibLoop1 = System.nanoTime
// println(fibLoop(5))
// println(fibLoop(15))
println(fibLoop(testNum))
println("fibLoop use time: "+(System.nanoTime - fibLoop1)*1E-9)

// -----------------------------Effificent recur
def fibRecur(n:Long):Long = {
    def helper(n:Long, a:Long, b:Long):Long = {
        if(n<=0) a+b else helper(n-1, b, a+b)
    }
    if(n<2) 1 else helper(n-2, 1, 1)
}

val fibRecur1 = System.nanoTime
// println(fibRecur(5))
// println(fibRecur(15))
println(fibRecur(testNum))
println("fibRecur use time: "+(System.nanoTime - fibRecur1)*1E-9)

// -----------------------------ordinary recur with memo
def fibMemo(n:Long, arr:Array[Long]):Long = {
    if(arr(n.toInt) != -1L) arr(n.toInt) else {
        arr(n.toInt) = if(n<2L) 1L else fibMemo(n-1, arr)+fibMemo(n-2, arr)
        arr(n.toInt)
    }
}
val fibMemo1 = System.nanoTime
// you must know that, this array must lie out of the recursion function, why? if inside it ,every recursion will build a new emepty one.
val arr1 = Array.fill(1000)(-1L)
val arr2 = Array.fill(1000)(-1L)
val arr3 = Array.fill(1000)(-1L)
// println(fibMemo(5,arr1))
// println(fibMemo(15,arr2))
println(fibMemo(testNum,arr3))
println("fibMemo use time: "+(System.nanoTime - fibMemo1)*1E-9)

// ----------------------------Efficient-recur with memo
def fibRecurMemo(n:Long, arr:Array[Long]):Long = {
    def helper(n:Long, a:Long, b:Long):Long = {
        if(arr(n.toInt) != -1L) arr(n.toInt) else {
            arr(n.toInt) = if(n<=0) a+b else helper(n-1, b, a+b)
            arr(n.toInt)
        }
    }

    if(n<2) 1 else helper(n-2, 1, 1)
}
val fibRecurMemo1 = System.nanoTime
// you must know that, this array must lie out of the recursion function, why? if inside it ,every recursion will build a new emepty one.
val arr4 = Array.fill(1000)(-1L)
val arr5 = Array.fill(1000)(-1L)
val arr6 = Array.fill(1000)(-1L)
// println(fibRecurMemo(5,arr4))
// println(fibRecurMemo(15,arr5))
println(fibRecurMemo(testNum,arr6))
println("fibRecurMemo use time: "+(System.nanoTime - fibRecurMemo1)*1E-9)

// arr display
println(arr3.mkString(", "))
println(arr6.mkString(", "))