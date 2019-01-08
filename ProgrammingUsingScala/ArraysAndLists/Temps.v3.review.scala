// pass by name 构造平台函数
// curry 构造可复用抽象函数

// pulling out information:high-temps, low-temps from dataset by Array fill and tabulate
// "xxx","xxx","xxx","xxx","xxx","1987-02-02",,"98","49" --> arr(98,49)
def parseInfo(line:String):Array[Double] = {
    Array(line.split(",")(8).diff("\"\"").toDouble, line.split(",")(9).diff("\"\"").toDouble)
}
val lines = Array.fill(readInt)(parseInfo(readLine))
lines.last.foreach(println)
