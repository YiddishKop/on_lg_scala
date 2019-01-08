// 5 methods to implement fibonacci number
// ordinary recur
// for
// efficient recur
// ordinary recur with memo
// efficient recur with memo

// test fibonacci without memo 
def timeUsed(fn: Long => Long, nth:Long) {
    val start = System.nanoTime
    println(s"${nth} number of fibo is : ${fn(nth)}")
    println(s"time used: ${(System.nanoTime-start)*1E-9}")
}
def timeUsedMem(fn: (Long,Array[Long]) => Long, nth:Long, arr:Array[Long]) {
    val start = System.nanoTime
    println(s"${nth} number of fibo is : ${fn(nth, arr)}")
    println(s"time used: ${(System.nanoTime-start)*1E-9}")
}

def orFib(n:Long):Long = {
    if(n<2L) 1L else orFib(n-1) + orFib(n-2)
}

def forFib(n:Long):Long = {
    if(n<2L) 1L else {
        var a = 1L
        var b = 1L
        var c = a+b
        for(i <- 3L to n) {
            a = b
            b = c
            c = a+b
        }
        c
    }
}

def effRecurFib(n:Long):Long = {
    def helper(n:Long, a:Long, b:Long):Long = {
        if(n<=0) a+b else helper(n-1L, b, a+b)
    }
    if(n<2L) 1L else helper(n-2L, 1L, 1L)
}

def memoOrRecurFib(n:Long, arr:Array[Long]):Long = {
    if(arr(n.toInt) != -1) arr(n.toInt) else{
        arr(n.toInt) = if (n<2L) 1L else memoOrRecurFib(n-1L, arr) + memoOrRecurFib(n-2L, arr)
        arr(n.toInt)
    }
}

def memoEffRecurFib(n:Long, arr:Array[Long]):Long = {
    def helper(n:Long, a:Long, b:Long):Long = {
        if(n<=0) a+b else helper(n-1, b, a+b)
    }
    if(arr(n.toInt) != -1) arr(n.toInt) else{
        arr(n.toInt) = if (n<2L) 1L else helper(n-2, 1, 1)
        arr(n.toInt)
    }
}

// for memo
val arr1 = Array.fill(5000)(-1L)
val arr2 = Array.fill(5000)(-1L)
val arr3 = Array.fill(5000)(-1L)
val arr4 = Array.fill(5000)(-1L)
// test number
val fiboNumSm = 10
val fiboNumBg = 3500
println("---------------SMALL--------------")
timeUsed(orFib, fiboNumSm)
timeUsed(forFib, fiboNumSm)
timeUsed(effRecurFib, fiboNumSm)
timeUsedMem(memoOrRecurFib, fiboNumSm, arr1)
timeUsedMem(memoEffRecurFib, fiboNumSm, arr2)
println("--------------BIG---------------")
timeUsed(forFib, fiboNumBg)
timeUsed(effRecurFib, fiboNumBg)
timeUsedMem(memoOrRecurFib, fiboNumBg, arr3)
timeUsedMem(memoEffRecurFib, fiboNumBg, arr4)