// use for-yield-if
val numPoints = 1000

// 1. get Points to represent the points in 2-D space by Array
val pnts = Array.fill(numPoints)((math.random),(math.random))

// 2. get less<1 distance directly by for-yield-if 
val distsLessThan1 = for((x,y) <- pnts; if math.sqrt(x*x + y*y) < 1) yield (x,y)
val numInQuarterCircle = distsLessThan1.length

println(s"Pi approximate to: ${4.0 * numInQuarterCircle / numPoints}")
