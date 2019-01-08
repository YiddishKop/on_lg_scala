// approximate Pi by count the number of points locate in 1-radius circle

val numPoints = 2000000
// 1. make 100 points randomly
val pnts = Array.fill(numPoints)((math.random, math.random))
// println(s"100 points: ${pnts.foreach(println)}")
val dists = for((x,y) <- pnts) yield math.sqrt(x*x + y*y)
// println(s"100 distances: ${dists.foreach(println)}")
val numInSquare = numPoints
val numInQuaterCircle = dists.count(_<1)
println(s"numInQuaterCircle is: $numInQuaterCircle")

// 2. S_square / 1/4S_circle = numInSquare / numInQuaterCircle
// 4/Pi = numInSquare/numInQuaterCircle => Pi = 4*numInQuaterCircle / numInSquare
println("Pi approximation: " + 4.0*numInQuaterCircle/numInSquare)