// matrix summation, with element-wise added
def matrixAdd(m1:Array[Array[Double]], m2:Array[Array[Double]]):Array[Array[Double]] = {
    val rowNum = m1.length
    val columnNum = m1(0).length
    // method 1: use nested for
    // val resultMatrix = for(i <- 0 to rowNum-1) yield {
    //     (for (j <- 0 to columnNum-1) yield m1(i)(j) + m2(i)(j)).toArray
    // }
    // resultMatrix.toArray 

    // method 2: use tabulate
    // val resultMatrix = Array.tabulate(rowNum,columnNum)((i,j) => m1(i)(j) + m2(i)(j))
    // resultMatrix

    // method 3: use for zip
    // 但凡涉及到 element-wise 操作的，都可以用 zip 把对应两个 element 搞到一起
    // 再通过 for 的 match pattern 功能对其进行匹配/析出/处理
    for ((r1, r2) <- m1.zip(m2)) yield {
        for((x1,x2) <- r1.zip(r2)) yield x1 + x2
    } 
}

val m1 = Array.fill(3,3)(1.0)
val m2 = Array.fill(3,3)(3.0)

val newMatrix = matrixAdd(m1, m2)
newMatrix.foreach(a => a.foreach(println))
