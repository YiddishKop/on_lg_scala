// function to fill all elments of an array from start_index
def fillArray(arr:Array[Int], value:Int, start_index:Int) {
    if(start_index < arr.length) {
        arr(start_index) = value
        fillArray(arr, value, start_index+1)
    }
}

// function to print an array
def printArray(arr:Array[Int], index:Int) {
    if(index < arr.length) {
        print(arr(index) + " ")
        printArray(arr, index+1)
    } else {
        println()
    }
}

// fill an array with user input
def readArray(arr:Array[Int], index:Int) {
    if(index < arr.length) {
        arr(index) = readInt
        readArray(arr, index+1)
    }
}

// function to sum elements of an array
def sumArray(arr:Array[Int], index:Int):Int = {
    if(index < arr.length) {
        arr(index) + sumArray(arr, index+1)
    } else {
        0
    }
}

// make an array and use it with those function
val nums = new Array[Int](5)
fillArray(nums, 5, 0)
printArray(nums, 0)
readArray(nums, 0)
printArray(nums, 0)
println(sumArray(nums,0))