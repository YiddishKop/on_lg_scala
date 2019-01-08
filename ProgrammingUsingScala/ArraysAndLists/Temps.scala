/**
很经典的例子，详细演示了：
1. 读取数据矩阵：
    1. 如何读取 .csv 文件 --- by redirecting stdin from keyboard to .csv file
2. 转换数据矩阵：
    1. 如何使用 map + split 函数提取我需要的列 --- lines.map(line => {xxx})
    2. 如何使用 filter 过滤不合条件的行 --- lines.filter(!_.contains(",.,"))
3. 统计转换后数据矩阵：
    1. 如何使用 count 统计提取出的列大小 --- highs.count(_>100)
 */
// 把 file 构建成一个 Array，每行作为 Array 的一个 element
def readAllLines(index:Int, lines:Array[String]) {
     if(index < lines.length) {
        lines(index) = readLine // 每次读取一行，逐次放入 Array 的 index 位置
        readAllLines(index+1, lines)
     }
}

// stdin 由 file 输入之后，其读取的Int，就是来自 file 中第一个数字
val numLines = readInt 

// 建立一个空数组 
val lines = new Array[String](numLines) 

/* 把读取的数字
(这里下载好.csv文件之后做一些小处理：
    1. 把第一行输出；
    2. 添加总行数作为第一行)
作为 Array 长度来建立一个 Array
*/
readAllLines(0, lines) 

/* 这里一定要搞清楚你在处理的 sequence 的 元素是什么：
* lines 的所有 high-order sequence method 的处理对象都是 a String line
1. filter(!_.contains(",.,")) --- 留下不含有 ",.," 的 line（此处照抄老师的内容，新的 dataset 中不存在这个问题）
2. map(...) --- 获取一列：(1)把原来的 String line 通过 split 编程 an Array of ubstring --- 'parts'
                         (2)只选择第 8 索引元素作为每个 line 的新值。

highs 就是数据矩阵的某一列,存储形式为 Array
*/
val highs = lines.filter(!_.contains(",.,")).map(line => {
     val parts = line.split(",")
     parts(8).diff("\"\"").toDouble
})

// we can get the property of 'lines' by the following println.
println(lines.last)
println(lines.last.length)
println(lines.last.getClass)
println(lines.last.head)

println("hot days: " + highs.count(_>=100))
println("hottest days: " + highs.max)