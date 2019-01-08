// 3 sort and 3 testSort


// for test
def sortedTest1(arr:Array[Double]):Boolean = {
    var flag = true
    for(i <- 0 until arr.length - 1) {
        if (arr(i) > arr(i+1)) flag = false
    }
    flag
}

// while test
def sortedTest2(arr:Array[Double]):Boolean = {
    var i = 0
    while(i < arr.length - 1 && arr(i) < arr(i + 1)) i += 1
    i == arr.length - 1
}

// zip test
def sortedTest3(arr:Array[Double]):Boolean = {
    arr.zip(arr.tail).forall(a => a._1 <= a._2)
}

// higher-order for testing
def sortTest(sort: Array[Double] => Unit):Boolean = {
    val arrData = Array.fill(2000)(math.random)
    sort(arrData)
    sortedTest2(arrData)
}

// bubble
def bubbleSort(arr:Array[Double]) {
    var tmp = 0.0
    for(i <- 0 until arr.length-1; j <- 0 until arr.length-1-i) {
        if(arr(j)>arr(j+1)) {
            tmp = arr(j)
            arr(j) = arr(j+1)
            arr(j+1) = tmp
        }
    }
}

// selection
def minSort(arr:Array[Double]) {
    var tmp = 0.0
    for(i <- 0 until arr.length-1) {
        var min_index = i
        for(j <- i+1 until arr.length) {
            if(arr(min_index) > arr(j)) {
                min_index = j
            }
        }
        tmp = arr(min_index)
        arr(min_index) = arr(i)
        arr(i) = tmp
    }
}

// insertion
def insertionSort(arr:Array[Double]) {
    var tmp = 0.0
    for(i <- 1 until arr.length) {
        tmp = arr(i) 
        var j = i - 1
        while(j > -1 && arr(j) > tmp) {
            arr(j+1) = arr(j)    
            j -= 1
        }
        arr(j+1) = tmp
    }    
}

println(sortTest(bubbleSort))
println(sortTest(minSort))
println(sortTest(insertionSort))

// How long these 3 algorithm takes.
def timeSort(a:Array[Double], sort:Array[Double] => Unit):Double = {
    val start = System.nanoTime
    sort(a)
    // make sure array is sorted
    println(sortedTest2(a))
    (System.nanoTime - start)*1e-9
}

val bigNums = Array.fill(100000)(math.random)

// println(timeSort(bigNums, bubbleSort))
println(timeSort(bigNums, minSort))
// println(timeSort(bigNums, insertionSort))