// Permutation: all order of combination by give elements
// 1,2,3,4
// 1,2,4,3
// 1,3,2,4
// ....

def permutation(lst:List[Int]):List[List[Int]] = lst match{
    case Nil => List(Nil)
    case List(a) => List(lst)
    case _ => 
        (for(i <- lst.indices.toList) yield {
            val (before, rest) = lst.splitAt(i)
            val elem = rest.head
            val subpermutes = permutation(before ++ rest.tail)
            subpermutes.map(elem::_)
        }).flatten
}

println(permutation(List(1,2,3,4)))
println(permutation(List(1,2,3,4)).length)