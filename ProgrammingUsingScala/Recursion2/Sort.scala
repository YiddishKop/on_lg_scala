// merge sort

def merge(a:List[Int], b:List[Int]):List[Int] = (a,b) match{
    case (Nil,_) => b
    case (_,Nil) => a
    case (x::xs, y::ys) =>
        if(x<y) x :: merge(xs, b)
        else y :: merge(a, ys)
}

def mergeSort(lst:List[Int]):List[Int] = {
    if(lst.length<2) lst
    else {
        val (first, second) = lst.splitAt(lst.length/2)
        merge(mergeSort(first), mergeSort(second))
    }
}

def quickSort(lst:List[Int]):List[Int] = lst match {
    case Nil => Nil
    case x :: Nil => lst
    case _ =>
        val p = lst.head
        val (before, after) = lst.tail.partition(_ < p)
        quickSort(before) ++ (p :: quickSort(after))
}


val nums = List.fill(10)(util.Random.nextInt(100))
println(nums.mkString(", "))
println(mergeSort(nums).mkString(", "))
println(quickSort(nums).mkString(", "))