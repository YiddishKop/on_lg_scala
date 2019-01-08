// permutaion of a give List of numbers
// given: 1 2 3 4
// produce: 1234, 1243, 1324, 1342, 1432, 1423, 2143, 2134,....

def permuta(lst:List[Int]):List[List[Int]] = lst match{
    case Nil => List(Nil)
    case List(a) => List(lst) 
    case _ =>
        (for(i <- lst.indices.toList) yield {
            val (bef, aft) = lst.splitAt(i)
            val ele = aft.head
            val subLst = bef ++ aft.tail
            val permutOfSub = permuta(subLst)
            permutOfSub.map(a => lst(i)::a)
        }).flatten
}

val lst = List(1,2,3,4)
permuta(lst).foreach(println)