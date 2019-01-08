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

// get information of: year, month, day, average tmp, high tmp, low tmp
def extractData(line:String):(Int, Int, Int, Double, Double, Double) = {
     val parts = line.split(",")
     (parts(3).diff("\"\"").split("-")(0).toInt,
     parts(3).diff("\"\"").split("-")(1).toInt,
     parts(3).diff("\"\"").split("-")(2).toInt,
     if (parts(7).diff("\"\"").length == 0) 0 else parts(7).diff("\"\"").toDouble, // handle the null value situation, like
                                                                                   // "USW00012921","SAN ANTONIO INTERNATIONAL AIRPORT, TX US","2010-12-31","0.00","0.0","0",,"68","50"
     parts(8).diff("\"\"").toDouble,
     parts(9).diff("\"\"").toDouble)
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

/* 这里一定要搞清楚你在处理的 sequence 的元素是什么：
* lines 的所有 high-order sequence method 的处理对象都是 a String line
1. filter(!_.contains(",.,")) --- 留下不含有 ",.," 的 line（此处照抄老师的内容，新的 dataset 中不存在这个问题）
2. map(...) --- 获取一列：(1)把原来的 String line 通过 split 编程 an Array of ubstring --- 'parts'
                         (2)只选择第 8 索引元素作为每个 line 的新值。
highs 就是数据矩阵的某一列,存储形式为 Array
*/
val data = lines.map(extractData)
println("Enter a data in yyyy-mm-dd")
val date = readLine
val Array(yStr, mStr, dStr) = date.split("-")
val year = yStr.toInt
val month = mStr.toInt
val day = dStr.toInt

var record = data.find(d => d._1==year && d._2==month && d._3==day)

record match {
    case Some((_,_,_,av,high,low)) =>
        println("compare " +av+ " to " +(high+low)/2)
    case None =>
        println("you dont have a record for that day")
}

println(record.getClass)
println(record)