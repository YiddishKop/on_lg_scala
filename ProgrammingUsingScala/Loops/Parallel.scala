// def fib(n:Int):Int = if(n<2) 1 else fib(n-1)+fib(n-2)

// for (i <- 30 to 15 by -2 par) println(fib(i))

// println(for(i <- 30 to 15 by -1 par) yield fib(i))

var i = 0
for (j <- 1 to 1000000 par) i += 1
println(i)

var h = 0
for (j <- 1 to 1000000) h += 1
println(h)