// break a List into groups of a particular size
// then take the average of each group
def averageGroups(nums:List[Double], size:Int):List[Double] = {
    if(nums.length > size) {
        val (group, other) = nums.splitAt(size)
        (average(group)) :: averageGroups(other, size)
    } else {
        (average(nums)) :: Nil
    }
}

def average(lst:List[Double]):Double = {
    if(lst.length > 0) (lst.head + average(lst.tail)*(lst.length-1))/lst.length
    else 0
}

val lst = List(3.0, 2.0, 1.0, 5.0, 6.0, 4.0, 6.0 ,1.0, 2.0, 3.0, 4.0, 5.0)
println(average(lst))
println(averageGroups(lst, 3).mkString(", "))