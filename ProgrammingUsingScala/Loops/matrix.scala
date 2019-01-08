// look up values in each of the two arrays and of course they must have the same size
def matrixAdd(m1:Array[Array[Double]], m2:Array[Array[Double]]):Array[Array[Double]] = {
    // method 1 --- [fill]: build, go through, filling
    // first, build a matrix same size with m1 and m2
    val ret = Array.fill(m1.length, m1(0).length)(0,0)
    // use 2 generators in for block to element-wisely add m1 and m2
    for(i <- 0 until ret.length; j <- 0 until ret(0).length)
        ret(i)(j) = m1(i)(j) + m2(i)(j)
    ret 

    // method 2 --- [tabulate]: fill it as we build it
    Array.tabulate(m1.length, m1(0).length)((i,j) => {
        m1(i)(j) + m2(i)(j) 
    }) 

    // method 3 --- [for yield]: zip + for yield 
    for((r1, r2) <- m1.zip(m2)) yield {
        for((x1,x2) <- r1.zip(r2)) yield x1 + x2
    }

}