
def testSorted(arr:Array[Double]):Boolean = {
    // Bad method:
    // 1. using 'var'
    // 2. inefficient --- even the 1st element is unsorted, the loop will go on to end
    var ret = true
    for(i <- 0 until arr.length - 1) {
        if(arr(i) >= arr(i+1)) ret = false
    }
    ret
}

def testSorted2(arr:Array[Double]):Boolean = {
    var i = 0
    while(i < arr.length - 1 && arr(i) <= arr(i+1)) i += 1 
    i >= arr.length - 1
}

def testSorted3(arr:Array[Double]):Boolean = {
    (arr.zip(arr.tail)).forall(t => t._1 <= t._2)
}


def testSort(sortFunc: Array[Double] => Unit):Boolean = {
    val nums = Array.fill(2000)(math.random)
    sortFunc(nums)
    testSorted3(nums) 
}


// mutable version: modify directly on array
def bubbleSort(arr:Array[Double]) {
    // flag bubble sort: outer loop will stop if nothing gets moved
    // non flag bubble sort: outer loop go through n - 1 times, this guarantee the result is sorted
    for (i <- 0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
        if(arr(j) > arr(j+1)) {
            val tmp = arr(j)
            arr(j) = arr(j+1)
            arr(j+1) = tmp
        }
    }
}

// selection sort
def minSort(arr:Array[Double]) {
    for(i <- 0 until arr.length - 1) {
        var min_index = i
        for(j <- i+1 until arr.length) {
            if(arr(j) < arr(min_index)) min_index = j
        }
        if (min_index != i) {
            val tmp = arr(i)
            arr(i) = arr(min_index)
            arr(min_index) = tmp
        }
    }
}

// insertion sort
def insertionSort(arr:Array[Double]) {
    for(i <- 1 until arr.length) {
        val tmp = arr(i)
        // use other loop, for reason that this loop should stop possibly at small than zero 
        var j = i - 1
        while(j > -1 && arr(j) > tmp) {
            arr(j+1) = arr(j )
            j -= 1
        }
        arr(j+1) = tmp 
    }
}

println(testSort(bubbleSort))
println(testSort(minSort))
println(testSort(insertionSort))



