val nums = Array(1,6,3,8,4,7,9,8,23,10,0,76,63)
val nums2 = Array(1,6,3,8,4,7,9,8,23,10,0,76,63)
// println(nums.indexOf(4))

// sequential search, O(n), slow 
def sequentialSearch(arr:Array[Int], searchFor:Int):Int = {
    var i = 0
    while(i<arr.length && arr(i) != searchFor) i += 1
    if (i < arr.length) i else -1
}

// binary search by for
def binarySearch(a:Array[Int], lookingFor:Int):Int = {
    var start = 0
    var end = a.length
    var mid = (start+end)/2
    while(a(mid) != lookingFor && start < end) {
        if(lookingFor < a(mid)) end = mid
        else start = mid+1
        mid = (start+end)/2
    }
    // println("what we find is :" + a(mid))
    if (a(mid) == lookingFor) mid else -1
}

// binary Search by recursion with embedding a helper function
def binarySearch2(a:Array[Int], lookingFor:Int):Int = {
    def recurHelper(start:Int, end:Int):Int = {
        if(start >= end) -1 
        else {
            val mid = (start+end)/2
            if(a(mid) == lookingFor) mid
            else if (a(mid) > lookingFor) recurHelper(start, mid)
            else recurHelper(mid+1, end)
        }
    } 
    recurHelper(0, a.length)
}

// sorted array by built-in API
val sortedNums = nums.sorted

println(sequentialSearch(sortedNums, 2))
println(binarySearch(sortedNums, 2))
println(binarySearch2(sortedNums, 2))
println(sortedNums.indexOf(2))
println(sequentialSearch(sortedNums, 63))
println(binarySearch(sortedNums, 63))
println(binarySearch2(sortedNums, 63))
println(sortedNums.indexOf(63))


