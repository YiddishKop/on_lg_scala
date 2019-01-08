// merge sort and quick sort

// two parts => left right
// repeated process => left merge right

val lst = List(5,3,8,7,9,1,4,2,6)

def merge(left:List[Int], right:List[Int]):List[Int] = (left,right) match{
    case (Nil,_) => right
    case (_,Nil) => left 
    case (a::b,c::d) =>
        {
            if(a > c) merge(c::left, d)
            else a::merge(b, right)
        } 
}

def mergeSort(lst:List[Int]):List[Int] = {
    val (left, right) = lst.splitAt(lst.length/2)
    if(lst.length == 1) lst
    else {
        merge(mergeSort(left), mergeSort(right))
    }
}

println(mergeSort(lst))

// get recur funtion:
//  head,tail / init,last / many parts: two parts
// reapted process: small pivot small
def quickSort(lst:List[Int]):List[Int] = {
    if(lst.length == 1 || lst.isEmpty) lst
    else {
        val pivot = lst(0)
        val (left,right) = lst.partition(_ < pivot) 
        quickSort(left) ++ (pivot::quickSort(right.tail))
    }
}

println(quickSort(lst))